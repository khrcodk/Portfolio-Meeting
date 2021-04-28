package global.sesoc.memo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.sesoc.memo.dao.MemberDAO;
import global.sesoc.memo.vo.MembersVO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private HttpSession session;
	
	public String selectMemberOne(MembersVO vo) {
		String path = "";
		MembersVO member = dao.selectMemberOne(vo);
		
		if(member != null) {
			session.setAttribute("loginId", member.getId());
			session.setAttribute("loginName", member.getName());
			path = "redirect:/room/main";
		} else {
			path = "redirect:/";
		}
		
		return path;
	}
	
	public String logout() {
		session.removeAttribute("loginId");
		session.removeAttribute("loginName");
		return "redirect:/";
	}
}
