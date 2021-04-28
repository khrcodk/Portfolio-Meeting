package global.sesoc.memo.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.memo.service.RoomService;
import global.sesoc.memo.vo.MemberGroupsVO;
import global.sesoc.memo.vo.ReservationsVO;

@Controller
@RequestMapping(value="/room")
public class RoomViewController {

	@Autowired
	private RoomService service;
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String main(Model model) {
		ArrayList<HashMap<String, Object>> list = service.selectRoomList();
		model.addAttribute("list", list);
		return "room/main";
	}
	
	@RequestMapping(value="/reservationForm", method = RequestMethod.GET)
	public String reservationForm(int roomNum, Model model) {
		HashMap<String, Object> map = service.reservationForm(roomNum);
		model.addAttribute("map", map);
		return "room/reservationForm";
	}
	
	@RequestMapping(value="/reservation", method = RequestMethod.POST)
	public String reservation(ReservationsVO reservation, String[] entry) {
		service.reservation(reservation, entry);
		return "redirect:/room/main";
	}
	
	@RequestMapping(value="/cancelReservation", method = RequestMethod.GET)
	public String cancelReservation(int reservationNum) {
		service.deleteReservation(reservationNum);
		return "redirect:/room/main";
	}
	
	@RequestMapping(value="/myReservation", method = RequestMethod.GET)
	public String myReservation(Model model) {
		ArrayList<HashMap<String, Object>> list = service.selectMyReservaion();
		model.addAttribute("list", list);
		return "room/myReservation";
	}
	
	@RequestMapping(value="/deleteMyReservation", method = RequestMethod.GET)
	public String deleteMyReservation(MemberGroupsVO vo) {
		service.deleteMyReservation(vo);
		return "redirect:/room/main";
	}
}
