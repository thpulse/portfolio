package kitri.recommend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kitri.reservation.vo.reservationVO;
import kitri.user.vo.UserVO;

@Controller
public class recommendController {
	@Autowired
	@Qualifier("recommenddao")
	recommendDAOImpl dao;
	
	@RequestMapping("/recommend/main.do")
	public String main(){
		List<UserVO> user_list = dao.allId();
		System.out.println(user_list);
		reservationVO vo = new reservationVO();
		//���� �����ϴ� id�� ������ num���� ī��Ʈ ���
		int cnt = dao.reserv_cnt(vo);
		System.out.println(cnt);
		return "recommend_test";
	}
}
