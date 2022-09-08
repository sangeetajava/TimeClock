package com.employee.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.entity.Shift;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.ShiftRepository;
import com.employee.vo.EmployeeVO;
import com.employee.vo.ShiftVO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	//controller -> service (VO/Entity)  -> repository
	@Autowired
	EmployeeRepository repository;

	@Autowired
	ShiftRepository shiftRepo;
	
	public List<EmployeeVO> getAllEmployee() {
		List<EmployeeVO> vos = new ArrayList<EmployeeVO> ();
		 List<Employee> entities = (List<Employee>) repository.findAll();
		
		 for(Employee entity:entities) {
			 EmployeeVO vo = new EmployeeVO();
			 BeanUtils.copyProperties(entity, vo);
			 vos.add(vo);
		 }
		 
		return vos;
	}

	public EmployeeVO getEmployee(int id) {
		EmployeeVO vo = new EmployeeVO();
		Optional<Employee> employee = repository.findById(id);
		BeanUtils.copyProperties(employee.get(), vo);
		if(vo.getDepartment().equals("IT")) {
			vo.setProfile("True");
		}else {
			vo.setProfile("false");
		}
		return vo;
	}

	public String deleteEmployee(int id) {
		try {
			repository.deleteById(id);
		}catch(Exception e) {
			return "Delete not done";
		}
		return "Delete done";
	}

	public String createEmlpoyee(EmployeeVO vo) {
		try {
			Employee entity = new Employee();
			BeanUtils.copyProperties(vo, entity);
			repository.save(entity);
		}catch(Exception e) {
			return "Create not done";
		}
		return "create done";
	}

	public String updateEmlpoyee(EmployeeVO vo) {
		try {
			Employee entity = new Employee();
			BeanUtils.copyProperties(vo, entity);
			repository.save(entity);
		}catch(Exception e) {
			return "Update not done";
		}
		return "Update done";
	}

	public EmployeeVO authentication(String email, String password) {
		EmployeeVO vo = new EmployeeVO();
		Optional<Employee>  emp = repository.findByEmailAndPassword(email,password);
		if(emp.isPresent()) {
			BeanUtils.copyProperties(emp.get() ,vo );
		}
		
		return vo;
	}

	public List<ShiftVO> getShifts(int empId) {
		List<ShiftVO> shiftsVos = new ArrayList<ShiftVO>();
		List<Shift> shifts = shiftRepo.findAllShiftsByEmployee(empId);
		
		for(Shift entity :shifts) {
			ShiftVO vo = new ShiftVO();
			BeanUtils.copyProperties(entity, vo);
			shiftsVos.add(vo);
		}
		return shiftsVos;
	}


	public Boolean addShift(int empId) {
		Optional<Employee> emp = repository.findById(empId);
		Optional<Shift> shift = shiftRepo.findByStatusAndUser("Working",emp.get());
		if(shift.isPresent()) {
			return false;
		}else {
			Shift s = new Shift();
			s.setStartTime(new Timestamp(new Date().getTime()));
			s.setStatus("Working");
			s.setUser(emp.get());
			shiftRepo.save(s);
			return true;
		}
	}

	public String endShift(int empId) {
		Optional<Employee> emp = repository.findById(empId);
		Optional<Shift> shift = shiftRepo.findByStatusAndUser("Working",emp.get());
		if(shift.isPresent()) {
			Shift s = shift.get();
			s.setEndTime(new Timestamp(new Date().getTime()));
			s.setStatus("NotWorking");
			s.setUser(emp.get());
			shiftRepo.save(s);
			return "Working shift has been ended";
		}else {
			
			return "No Working shift available to end";
		}
	}

}
