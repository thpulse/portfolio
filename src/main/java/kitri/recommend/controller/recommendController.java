package kitri.recommend.controller;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.mongodb.MongoDBDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kitri.reservation.vo.reservationVO;
import kitri.user.vo.UserVO;


@Controller
public class recommendController {
	@Autowired
	@Qualifier("recommenddao")
	recommendDAOImpl dao;
	@Autowired
	@Qualifier("recommendmongoservice")
	recommendMongoService mongoservice;
	
	@RequestMapping("/recommend/main.do")
	public ModelAndView main(){		
		ModelAndView mav = new ModelAndView();
		List<recommendReserveVO> list = dao.select_all();
		mav.setViewName("recommend_test");
		mav.addObject("list", list);	
		return mav;
	}
	@RequestMapping("/recommend/delete.do")
	public ModelAndView deleteAll(){		
		ModelAndView mav = new ModelAndView();
		dao.delete();
		List<recommendReserveVO> list = dao.select_all();				
		mav.setViewName("redirect:/recommend/main.do");
		mav.addObject("list", list);	
		return mav;
	}
	@RequestMapping("/recommend/recommend.do")
	public ModelAndView mahout() throws IOException, TasteException{		
		ModelAndView mav = new ModelAndView();
		List<recommendReserveVO> list = dao.select_all();
		/*
		DataModel model = new FileDataModel(new File("C:\\test.csv"));
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1,similarity, model);
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		
		List<RecommendedItem> recommendations = recommender.recommend(2,3);//id�� 2���� ������� 3���� �������� ��õ
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}*/
		//DataModel model = new FileDataModel(new File("/path/to/dataset.csv"));
		/*RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		RecommenderBuilder builder = new MyRecommenderBuilder();
		double result = evaluator.evaluate(builder, null, model, 0.9, 1.0);//�������� 100%���� 10�۸� �׽�Ʈ�� �̾Ƽ� ���
*/				
		mav.setViewName("redirect:/recommend/main.do");
		mav.addObject("list", list);	
		return mav;
	}
	@RequestMapping("/recommend/mongoInsert.do")
	public ModelAndView mongoInsert(){		
		ModelAndView mav = new ModelAndView();
		List<recommendReserveVO> list = dao.select_all();

		for(int i=0; i < list.size(); i++){
			recommendDTO dto = new recommendDTO();
			recommendReserveVO vo = list.get(i);
			dto.setUser_id(vo.getUser_id());
			dto.setItem_id(vo.getPrf_id());
			dto.setPreference((String.valueOf(vo.getCount())));
			System.out.println(dto);
			mongoservice.insertDocument(dto);
		}
		mav.setViewName("redirect:/recommend/main.do");
		mav.addObject("list", list);	
		return mav;
	}
	//MongoDB���� ���Ͽ����� ����
	@RequestMapping("/recommend/reload.do")
	public ModelAndView reloadAll(){		
		ModelAndView mav = new ModelAndView();
		//���Ͽ� ����� SQL�� ����Ǿ��ִ°� �����ϰ� ���� ����
		dao.deleteMahout();
		List<recommendReserveVO> list = dao.select_all();
		for(int i=0; i < list.size(); i++){
			recommendDTO dto = new recommendDTO();
			recommendReserveVO vo = list.get(i);
			dto.setUser_id(vo.getUser_id());
			dto.setItem_id(vo.getPrf_id());
			dto.setPreference((String.valueOf(vo.getCount())));
			mongoservice.insertDocument(dto);
		}
		List<UserVO> user_list = dao.allId();
		for(int i=0; i<user_list.size();i++){
			UserVO vo = user_list.get(i);
			MongoDBDataModel dataModel;
			try {			
				dataModel = new MongoDBDataModel("127.0.0.1", 27017, "recommend","reservation",false,false,null);
				System.out.println("����"+dataModel.toString());
				UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
				System.out.println("����2");
				UserNeighborhood neighborhood = 
						new ThresholdUserNeighborhood(0.1, similarity, dataModel);
				System.out.println("����3");
				UserBasedRecommender recommender = 
						new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
				System.out.println("����4");
						
				//�迭�� id����
				Long userId = Long.parseLong(dataModel.fromIdToLong(vo.getUser_id(), true));
				//Stirng id�� 
				System.out.println(userId);
				List<RecommendedItem> recommendations = recommender.recommend(userId, 3);
				System.out.println(recommendations.size());
				if(recommendations.size()> 0){
					
					for (RecommendedItem recommendation : recommendations) {
						System.out.println("hi!");
					  System.out.println(recommendation+"=====>"+dataModel.fromLongToId(recommendation.getItemID()));
					  recommendResultVO resultVO = new recommendResultVO();
					  resultVO.setUser_id(vo.getUser_id());
					  resultVO.setItem_id(dataModel.fromLongToId(recommendation.getItemID()));
					  //���̵𺰷� �˻��� ��� ����
					  dao.insertMahout(resultVO);
					}
				}				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (TasteException e) {
				e.printStackTrace();
			}
		}	
		mav.setViewName("redirect:/recommend/main.do");
		mav.addObject("list", list);	
		return mav;
	}
	@RequestMapping("/recommend/update.do")
	public ModelAndView show_reserv(){
		ModelAndView mav = new ModelAndView();
		List<UserVO> user_list = dao.allId();
		List<List<reservationVO>> reserv_list = new ArrayList<List<reservationVO>>();
		//���� �����ϴ� id�� ������ num���� ī��Ʈ ���
		for(int i=0; i<user_list.size();i++){
			UserVO vo = user_list.get(i);
			List<reservationVO> reserv = dao.reserv_cnt(vo);
			reserv_list.add(reserv);			
		}		
		//���� ������ id�� ����ID���� ������ ������ ��� ����
		for(int i=0; i<user_list.size();i++){
			UserVO vo2 = user_list.get(i);
			//���� id�� reserv_num,prf_id,user_idȹ��
			List<reservationVO> reserv = dao.reserv_cnt(vo2);
			System.out.println(reserv);
			for(int j=0; j < reserv.size();j++){
				//id+reserv_id ī��Ʈ!
				int cnt = dao.recommend_cnt(reserv.get(j));
				recommendReserveVO insertVO = new recommendReserveVO();
				insertVO.setCount(cnt);
				insertVO.setPrf_id(reserv.get(j).getPrf_id());
				insertVO.setUser_id(vo2.getUser_id());
				dao.insert_reserv(insertVO);
			}			
		}
		mav.setViewName("redirect:/recommend/main.do");
		return mav;
	}
}
