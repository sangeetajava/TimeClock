package com.employee.service;

import java.util.List;

import com.employee.vo.EmployeeVO;
import com.employee.vo.ShiftVO;

public interface EmployeeService {
	
  List<EmployeeVO> getAllEmployee();
  
  EmployeeVO getEmployee(int id);
  
  String deleteEmployee(int id);
  
  String createEmlpoyee(EmployeeVO vo);
  
  String updateEmlpoyee(EmployeeVO vo);
  
  EmployeeVO authentication(String email,String password);
  
  List<ShiftVO>	getShifts(int empId);
  
  Boolean addShift(int empId);
  String endShift(int empId);
}
