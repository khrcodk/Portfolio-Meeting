package global.sesoc.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.memo.service.MemberService;
import global.sesoc.memo.vo.MembersVO;

@Controller
@RequestMapping(value="/member")
public class MemberViewController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public String login(MembersVO vo) {
		return service.selectMemberOne(vo);
	}

	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout() {
		return service.logout();
	}
	
}
