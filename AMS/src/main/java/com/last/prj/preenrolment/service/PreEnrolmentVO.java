package com.last.prj.preenrolment.service;

import java.util.List;

import com.last.prj.lecture.service.LectureVO;

import lombok.Data;

@Data
public class PreEnrolmentVO {
	private String sid; //학번
	private String opennum; //강의 개설번호
	private String retake; //재수강여부
	
	
	private String lnum;  //강의번호
	private String lname; //강의명
	private int credit; //학점
	private String division; //이수구분
	private String timetable;  //강의시간 강의명
	private int grade; //학년
	
	private String mcode; //전공번호
	private String dcode; //학과번호
	private String mname; //전공명
	private String dname; //학과명
	
	private String time;
}
