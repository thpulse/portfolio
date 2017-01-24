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
		
		List<RecommendedItem> recommendations = recommender.recommend(2,3);//id가 2번인 사람에게 3개의 아이템을 추천
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}*/
		//DataModel model = new FileDataModel(new File("/path/to/dataset.csv"));
		/*RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		RecommenderBuilder builder = new MyRecommenderBuilder();
		double result = evaluator.evaluate(builder, null, model, 0.9, 1.0);//데이터의 100%에서 10퍼를 테스트로 뽑아서 계산
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
	//MongoDB에서 머하웃으로 삽입
	@RequestMapping("/recommend/reload.do")
	public ModelAndView reloadAll(){		
		ModelAndView mav = new ModelAndView();
		//머하웃 결과값 SQL에 저장되어있는거 삭제하고 새로 삽입
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
				System.out.println("성공"+dataModel.toString());
				UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
				System.out.println("성공2");
				UserNeighborhood neighborhood = 
						new ThresholdUserNeighborhood(0.1, similarity, dataModel);
				System.out.println("성공3");
				UserBasedRecommender recommender = 
						new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
				System.out.println("성공4");
						
				//배열로 id삽입
				Long userId = Long.parseLong(dataModel.fromIdToLong(vo.getUser_id(), true));
				//Stirng id를 
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
					  //아이디별로 검색한 결과 삽입
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
		//현재 존재하는 id가 예약한 num토대로 카운트 계산
		for(int i=0; i<user_list.size();i++){
			UserVO vo = user_list.get(i);
			List<reservationVO> reserv = dao.reserv_cnt(vo);
			reserv_list.add(reserv);			
		}		
		//현재 가져온 id로 공연ID별로 예약한 갯수를 묶어서 저장
		for(int i=0; i<user_list.size();i++){
			UserVO vo2 = user_list.get(i);
			//받은 id로 reserv_num,prf_id,user_id획득
			List<reservationVO> reserv = dao.reserv_cnt(vo2);
			System.out.println(reserv);
			for(int j=0; j < reserv.size();j++){
				//id+reserv_id 카운트!
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
