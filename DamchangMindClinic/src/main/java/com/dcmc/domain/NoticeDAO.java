package com.dcmc.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDAO {
	int bno;
	String title;
	String content;
	String showYn;
	String writer;
	Date registerDate;
}
