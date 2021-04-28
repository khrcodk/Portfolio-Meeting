package global.sesoc.memo.dao;

import java.util.ArrayList;
import java.util.HashMap;

import global.sesoc.memo.vo.MemberGroupsVO;
import global.sesoc.memo.vo.ReservationsVO;
import global.sesoc.memo.vo.RoomsVO;

public interface RoomMapper {
	public ArrayList<HashMap<String, Object>> selectRoomList();
	public RoomsVO selectRoomOne(int roomNum);
	public void insertReservation(ReservationsVO reservation);
	public void groupInsert(HashMap<String, Object> params);
	public void deleteReservation(int reservationNum);
	public ArrayList<HashMap<String, Object>>selectMyReservaion(String id);
	public void deleteMyReservation(MemberGroupsVO vo);
}
