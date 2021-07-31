package com.last.prj.lecture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last.prj.lecture.service.LectureService;
import com.last.prj.lecture.service.LectureVO;

@Service
public class LectureServiceImpl implements LectureService{
	@Autowired
	LectureMapper Lmap;
	
	@Override
	public int LectureInsert(LectureVO vo) {
		return Lmap.LectureInsert(vo);
	}

	@Override
	public List<LectureVO> LectureList(String id) {
		
		return Lmap.LectureList(id);
	}

	@Override
	public int LectureUpdate(LectureVO vo) {
		for(int i =0; i<vo.getUpdatedRows().size();i++) {
			Lmap.LectureUpdate(vo.getUpdatedRows().get(i));
		}
		return 0;
	}

	@Override
	public int LectureDelete(LectureVO vo) {
		for(int i=0; i<vo.getDeletedRows().size();i++) {
			Lmap.LectureDelete(vo.getDeletedRows().get(i));
		}
		return 0;
	}

}