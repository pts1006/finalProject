package com.last.prj.hwProfessor.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last.prj.hwProfessor.service.HwProfessorService;
import com.last.prj.hwProfessor.service.HwProfessorVO;

@Service
public class HwProfessorServiceImpl implements HwProfessorService{

	@Autowired
	HwProfessorMap map;

	@Override
	public List<Map<String, Object>> hw_professorSelectList(HwProfessorVO vo) {
		
		return map.hw_professorSelectList(vo);
	}

	@Override
	public HwProfessorVO hw_professorSelect(HwProfessorVO vo) {
	
		return map.hw_professorSelect(vo);
	}

	@Override
	public int hw_professorInsert(HwProfessorVO vo) {
		
		return map.hw_professorInsert(vo);
	}

	@Override
	public int hw_professorDelete(HwProfessorVO vo) {
		
		return map.hw_professorDelete(vo);
	}

	@Override
	public int hw_professorUpdate(HwProfessorVO vo) {
		
		return map.hw_professorUpdate(vo);
	}

	@Override
	public List<Map<String, Object>> hw_submitList(HwProfessorVO vo) {
		
		return map.hw_submitList(vo);
	}


	@Override
	public List<Map<String, Object>> hw_ySelect(HwProfessorVO vo) {
	
		return map.hw_ySelect(vo);
	}

	@Override
	public List<Map<String, Object>> hwLname(HwProfessorVO vo) {
		
		return map.hwLname(vo);
	}

	@Override
	public List<Map<String, Object>> hwSearchList(HwProfessorVO vo) {
		
		return map.hwSearchList(vo);
	}
	
	
}