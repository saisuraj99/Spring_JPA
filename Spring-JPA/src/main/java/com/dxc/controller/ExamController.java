package com.dxc.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.dao.ExamRepository;
import com.dxc.model.Exam;

@Controller
public class ExamController {
       
	@Autowired
	ExamRepository examRepository;
	
	@RequestMapping("exams")
	public ModelAndView displayexams() {
		ModelAndView modelAndView = new ModelAndView("displayexams");
		List<Exam> exam = (List<Exam>)examRepository.findAll();
		modelAndView.addObject("exams", exam);
		return modelAndView;
	}
	
	@RequestMapping("addexam")
	public String newexamform()
	{
		return "addexam";
	}
	
	@RequestMapping("examsave")
	public String addexam(@RequestParam("id") String id, @RequestParam("name") String name) throws ParseException
	{
		Exam exam = new Exam(id, name);
		examRepository.save(exam);
		return "redirect:/exams";
	}
	
	@RequestMapping("editexam")
	public String editexamform() {
		return "editexam";
	}
	
	@RequestMapping("examupdate")
	public String updateexam(@RequestParam("id") String id, @RequestParam("name") String name) throws ParseException
	{
		Exam exam = new Exam(id, name);
		examRepository.save(exam);
		return "redirect:/exams";
	}
	
	@RequestMapping("deleteexam")
	public String deleteExam(@RequestParam("id") String id)
	{
		examRepository.deleteById(id);
		return "redirect:/exams";
	}
	
	
}