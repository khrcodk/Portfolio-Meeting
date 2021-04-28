package global.sesoc.memo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.memo.vo.MembersVO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession session;
	
	public MembersVO selectMemberOne(MembersVO vo) {
		MembersVO member = null;
		
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			member = mapper.selectMemberOne(vo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	public ArrayList<MembersVO> selectMemberList(){
		ArrayList<MembersVO> list = null;
		
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			list = mapper.selectMemberList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
