package com.dcmc.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeDTO {
	int bno;
	String title;
	String content;
	String showYn;
	String writer;
	Date registerDate;
}
