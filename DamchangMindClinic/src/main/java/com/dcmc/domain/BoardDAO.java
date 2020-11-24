package com.dcmc.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDAO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String showYn;
	private String secretYn;
	private String password;
	private Date registerDate;
	private String replyYn;
	@Override
	public String toString() {
		return "BoardDAO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", showYn="
				+ showYn + ", secretYn=" + secretYn + ", password=" + password + ", registerDate=" + registerDate
				+ ", replyYn=" + replyYn + "]";
	}
}
