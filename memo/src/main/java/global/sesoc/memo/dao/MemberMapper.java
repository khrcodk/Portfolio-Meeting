package global.sesoc.memo.dao;

import java.util.ArrayList;

import global.sesoc.memo.vo.MembersVO;

public interface MemberMapper {
	public MembersVO selectMemberOne(MembersVO vo);
	public ArrayList<MembersVO> selectMemberList();
}
