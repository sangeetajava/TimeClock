package com.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entity.Employee;
import com.employee.entity.Shift;

public interface ShiftRepository extends JpaRepository<Shift, Integer> {
	
	@Query("SELECT tt FROM Shift tt where tt.user.id = :empId")
	List<Shift> findAllShiftsByEmployee(@Param("empId") int id);
	
	Optional<Shift> findByStatusAndUser(String status,Employee emp);
}
