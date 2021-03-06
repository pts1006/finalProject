package com.last.prj.professor.service;

import lombok.Data;

@Data
public class ProfessorLectureVO {
	private String division; //이수구분
	private int credit; //학점 
	private String pName; //교수이름
	private String email; // 교수 이메일
	private String pPhone; //교수 번호
	private String dName; //학과이름
	private String lrName;  //강의실 이름
	private String mName; // 전공이름
	private String pStaus;//교수 상태 
	private String lYear;//년도
	private String term;//학기
	private String schedule;//강의 시간
	private String dividenum;//강의 구분코드
	private String book;//교재
	private String pid;//교수 아이디
	
	private String lNum; // 강의번호
	private String dCode; //이수코드
	private String mCode; //전공코드
	private int lCode; //과목코드

	private String grade; //학년
	private int newlimitCount; //정원
	private String lName; //강의 이름
	
	
	private String w1; //주차
	private String w2;
	private String w3;
	private String w4;
	private String w5;
	private String w6;
	private String w7;
	private String w8; // 중간고사 주차
	private String w9;
	private String w10;
	private String w11;
	private String w12;
	private String w13;
	private String w14;
	private String w15;
	private String w16; // 기말고사 주차
	private String content; // 내용
	private String opennum; // 강의번호
	
}
