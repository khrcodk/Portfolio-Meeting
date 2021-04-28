package global.sesoc.memo.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import global.sesoc.memo.vo.MemberGroupsVO;
import global.sesoc.memo.vo.ReservationsVO;
import global.sesoc.memo.vo.RoomsVO;

@Repository
public class RoomDAO {
	
	@Autowired
	private SqlSession session;
	
	public ArrayList<HashMap<String, Object>> selectRoomList(){
		ArrayList<HashMap<String, Object>> list = null;
		try {
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			list = mapper.selectRoomList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public RoomsVO selectRoomOne(int roomNum) {
		RoomsVO vo = null;
		
		try {
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			vo = mapper.selectRoomOne(roomNum);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public void insertReservation(ReservationsVO reservation,String[] entry) throws Exception {
		try {
			
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			mapper.insertReservation(reservation);
			
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("reservationNum", reservation.getNum());
			params.put("entry", entry);
			
			mapper.groupInsert(params);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public void deleteReservation(int reservationNum) {
		try {
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			mapper.deleteReservation(reservationNum);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<HashMap<String, Object>>selectMyReservaion(String id){
		ArrayList<HashMap<String, Object>> list = null;
		try {
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			list = mapper.selectMyReservaion(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteMyReservation(MemberGroupsVO vo) {
		try {
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			mapper.deleteMyReservation(vo);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
