package com.last.prj.lectureInfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last.prj.lectureInfo.service.LectureInfoService;
import com.last.prj.lectureInfo.service.LectureInfoVO;

@Service
public class LectureInfoServiceImpl implements LectureInfoService {
	@Autowired
	LectureInfoMapper Lmap;
	
	@Override
	public List<LectureInfoVO> getLectureInfoList(String pId) {
		return Lmap.getLectureInfoList(pId);
	}

}
