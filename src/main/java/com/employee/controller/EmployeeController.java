package com.employee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.service.EmployeeService;
import com.employee.vo.EmployeeVO;
import com.employee.vo.ShiftVO;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/employeeShifts")
	public String home(Model model,HttpSession session) {
		EmployeeVO  loginVO2=(EmployeeVO)session.getAttribute("emp");
		if(loginVO2 != null) {
			List<ShiftVO> shifts = service.getShifts(loginVO2.getId());
			model.addAttribute("shifts", shifts);
			return "allShifts";
		}else {
			return "login";
		}
		
	}
	
	@GetMapping("/addShift")
	public String addShift(Model model,HttpSession session) { 
		EmployeeVO  loginVO2=(EmployeeVO)session.getAttribute("emp");
		if(loginVO2 != null) {
			Boolean added = service.addShift(loginVO2.getId());
			if(added) {
				model.addAttribute("message", "Working shift is has been added");
				return "redirect:employeeShifts";
			}else {
				model.addAttribute("message", "Working shift is already going on so cannot add more");
				List<ShiftVO> shifts = service.getShifts(loginVO2.getId());
				model.addAttribute("shifts", shifts);
				return "allShifts";
			}

			
		}else {
			return "login";
		}
	}
	
	@GetMapping("/endShift")
	public String endShift(Model model,HttpSession session) { 
		EmployeeVO  loginVO2=(EmployeeVO)session.getAttribute("emp");
		if(loginVO2 != null) {
			String ended = service.endShift(loginVO2.getId());
			model.addAttribute("message", ended);
			List<ShiftVO> shifts = service.getShifts(loginVO2.getId());
			model.addAttribute("shifts", shifts);
			return "allShifts";
		}else {
			return "login";
		}
	}
	
	
	@GetMapping("/allShift")
	public String allShift(Model model,HttpSession session) { 
		EmployeeVO  loginVO2=(EmployeeVO)session.getAttribute("emp");
		if(loginVO2 != null) {
			return "allShift";
		}else {
			return "login";
		}
		
	}
	
	@GetMapping("/registration")
	public String registration() {
		System.out.println("I m inside emp controller ********");
		return "registration";
	}
	
	@PostMapping("/registerEmployee")
	public String createEmployee(@ModelAttribute EmployeeVO vo, Model model) {
		String message =service.createEmlpoyee(vo);
		model.addAttribute("message", message);
		return "registration";
	} 
	
	@GetMapping("/getEmployee")
	public String getEmployee(Model model,HttpSession session) { 
		EmployeeVO  loginVO2=(EmployeeVO)session.getAttribute("emp");
		if(loginVO2 != null) {
			EmployeeVO vo = service.getEmployee(loginVO2.getId());
			model.addAttribute("employee", vo);
			
			return "employeeDetail";
		}else {
			return "login";
		}
		
		
	}
	
	@GetMapping("/login")
	public String employeeLogin( Model model) {
		return "login"; //call jsp/view
	}
	
	@PostMapping("/authentication")
	public String authentication(@RequestParam String email,@RequestParam String password, Model  model, HttpSession session) {
		EmployeeVO empDto = service.authentication(email , password );
		if(empDto.getId() !=0) {
			session.setAttribute("emp", empDto);
			session.setAttribute("email", empDto.getEmail());
			return "redirect:employeeShifts";
		}else{
			model.addAttribute("message", "user id password not correct");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String employeeLogin(  HttpSession session) {
		session.invalidate();
		return "login"; //call jsp/view
	}
	
	
}
