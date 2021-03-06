package com.last.prj.hwProfessor.service;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class HwProfessorVO {
	
	private String registerId;		//과제등록번호
	private String opennum;		//강의번호
	private Date registerDate;  //등록날짜
	private Date pperiod;		//제출기간
	private String registerFile;//양식파일
	private String pcomment;	//교수코멘트
	private String pid;			//교수번호
	private String lyear;		//강의년도
	private String term;		//강의학기
	private String lnum;		//강의코드
	private String lcode;		//강의코드
	private String submitId;	//과제제출한 고유번호
	private String submitSid;	//학생번호
	private String score;		//점수
	
	private List<HwProfessorVO> deletedRows;
	private List<HwProfessorVO> updatedRows;
	}

