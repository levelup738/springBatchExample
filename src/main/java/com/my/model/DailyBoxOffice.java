package com.my.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyBoxOffice {
	private String rnum;
	private String rank;
	private String rankInten;
	private String rankOldAndNew;
	private String movieCd;
	private String movieNm;
	private String openDt;
	private String salesAmt;
	private String salesShare;
	private String salesInten;
	private String salesChange;
	private String salesAcc;
	private String audiCnt;
	private String audiInten;
	private String audiChange;
	private String audiAcc;
	private String scrnCnt;
	private String showCnt;
}
