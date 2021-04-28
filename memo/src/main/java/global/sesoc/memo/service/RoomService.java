package global.sesoc.memo.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.sesoc.memo.dao.MemberDAO;
import global.sesoc.memo.dao.RoomDAO;
import global.sesoc.memo.vo.MemberGroupsVO;
import global.sesoc.memo.vo.MembersVO;
import global.sesoc.memo.vo.ReservationsVO;
import global.sesoc.memo.vo.RoomsVO;

@Service
public class RoomService {

	@Autowired
	private RoomDAO roomDao;
	@Autowired
	private MemberDAO memberDao;
	@Autowired
	private HttpSession session;
	
	
	public ArrayList<HashMap<String, Object>> selectRoomList(){
		return roomDao.selectRoomList();
	}
	
	public HashMap<String, Object> reservationForm(int roomNum){
		ArrayList<MembersVO> list = memberDao.selectMemberList();
		RoomsVO room = roomDao.selectRoomOne(roomNum);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("memberList", list);
		map.put("room", room);
		return map;
	}
	
	public void reservation(ReservationsVO reservation, String[] entry) {
		String loginId = (String)session.getAttribute("loginId");
		reservation.setMemberId(loginId);
		try {
			roomDao.insertReservation(reservation, entry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteReservation(int reservationNum) {
		roomDao.deleteReservation(reservationNum);
	}
	
	public ArrayList<HashMap<String, Object>>selectMyReservaion(){
		String loginId = (String)session.getAttribute("loginId");
		return roomDao.selectMyReservaion(loginId);
	}
	
	public void deleteMyReservation(MemberGroupsVO vo) {
		String loginId = (String)session.getAttribute("loginId");
		vo.setMemberId(loginId);
		roomDao.deleteMyReservation(vo);
	}
	
}
