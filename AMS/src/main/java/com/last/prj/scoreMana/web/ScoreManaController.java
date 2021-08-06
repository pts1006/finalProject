package com.last.prj.scoreMana.web;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.last.prj.lecture.service.LectureVO;
import com.last.prj.scoreMana.service.ScoreManaService;
import com.last.prj.scoreMana.service.ScoreManaVO;
import com.last.prj.students.service.StudentsVO;


@Controller
public class ScoreManaController {
@Autowired
	ScoreManaService SMdao;
	
	@RequestMapping("ScoreManaPage")
	public String ScoreManaPage(Model model, HttpSession session) {
		String sid = (String) session.getAttribute("id");
		StudentsVO vo = new StudentsVO();
		vo.setSid(sid);
		model.addAttribute("student",SMdao.EnrolmentStudent(vo));
		return "scoreMana/Enrolment.tiles";
	}

	@RequestMapping("EnrolmentList")
	@ResponseBody
	public Map<String, Object> EnrolmentList(HttpSession session,@RequestBody Map<String,String> map){
		String sid = (String) session.getAttribute("id");
		
		StudentsVO vo = SMdao.StudentSelectinfo(sid); //학생의 학년 가져오기
		
		LectureVO lvo = new LectureVO();
		lvo.setSeach(map.get("seach"));
		lvo.setSeachgubun(map.get("seachgubun"));
		lvo.setGrade(vo.getGrade());
		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, Object> datas = new HashMap<String, Object>();
		data.put("result", true);
		datas.put("contents", SMdao.EnrolmentList(lvo));
		data.put("data", datas);
		return data;
	}
	
	//중복 수강체크
	@RequestMapping("AjaxConfirm")
	@ResponseBody
	public int AjaxConfirm(@RequestParam("opennum") String opennum, HttpSession session) {
		String sid = (String) session.getAttribute("id");
		ScoreManaVO vo = new ScoreManaVO();
		vo.setSid(sid);
		vo.setOpennum(opennum);
		ScoreManaVO vo2 = SMdao.OverlapCheck(vo);
		
		System.out.println(vo2);
		//중복체크
		int i = 1;
		if(SMdao.OverlapCheck(vo)==null) { //중복수강 확인
			i = 0;
		}
		System.out.println(i);
		return i;
	}
	
	//수강 취소(삭제)
	@RequestMapping("AjaxEnrolmentDelete")
	public String AjaxEnrolmentDelete(@RequestParam("opennum") String opennum,Model model, HttpSession session) {
		String sid = (String) session.getAttribute("id");
		String message = "";
		ScoreManaVO vo = new ScoreManaVO();
		vo.setSid(sid);
		vo.setOpennum(opennum);
		
		int i = SMdao.AjaxEnrolmentDelete(vo);
			if(i>0) {
				message = "수강취소가 완료되었습니다.";
			}else {
				message = "수강취소가 실패되었습니다.";
			}
		model.addAttribute("message",message);
		return "redirect:ScoreManaPage";
	}
	
	//수강신청(insert)
	@RequestMapping("AjaxEnrolmentInsert")
	public String AjaxEnrolmentInsert(@RequestParam("opennum") String opennum, HttpSession session) {
		String sid = (String) session.getAttribute("id");
		ScoreManaVO vo = new ScoreManaVO();
		vo.setSid(sid);
		vo.setOpennum(opennum);
		SMdao.AjaxEnrolmentInsert(vo);
		return "redirect:ScoreManaPage";
	}
	
	//재이수 확인
	@RequestMapping("AjaxRetakeChek")
	@ResponseBody
	public String AjaxRetakeChek(@RequestParam("opennum") String opennum, HttpSession session) {
		String sid = (String) session.getAttribute("id");
		ScoreManaVO vo = new ScoreManaVO();
		vo.setSid(sid);
		vo.setOpennum(opennum);
		return SMdao.RetakeChek(vo);
	}
	
	@RequestMapping("AjaxcreditCheck")
	@ResponseBody
	public int AjaxCreditCheck(HttpSession session) {
		String sid = (String) session.getAttribute("id");
		int result = SMdao.AjaxCreditCheck(sid);
		if(result==100) {
			result=0;
		}
		System.out.println(result);
		return result;
	}
}
