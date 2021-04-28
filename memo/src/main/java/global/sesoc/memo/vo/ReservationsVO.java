package global.sesoc.memo.vo;

import lombok.Data;

@Data
public class ReservationsVO {
	private int num;
	private String startTime;
	private String endTime;
	private String title;
	private String memberId;
	private int roomNum;
}
