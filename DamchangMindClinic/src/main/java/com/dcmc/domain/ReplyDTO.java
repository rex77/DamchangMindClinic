package com.dcmc.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyDTO {
	private int rno;
	private int bno;
	private String content;
	private String writer;
	private Date registerDate;
}
