package com.last.prj.hw_student.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class hw_studentVO {

	private int registerId;	//과제제출 번호
	private int submitId;	//과제들옥 번호(구분하기위한 PK)
	private String submitSid;//제출학생 학번
	private String submitFile;//제출파일
	private Date submitDate;//제출 날짜
	private String sComment;// 학생 코멘트
	private int score; //점수
}
