package com.my.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoxOfficeResult {
	private String boxofficeType;
	private String showRange;
	private List<DailyBoxOffice> dailyBoxOfficeList;
}
