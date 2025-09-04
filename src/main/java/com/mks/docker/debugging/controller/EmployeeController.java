package com.mks.docker.debugging.controller;

import com.mks.docker.debugging.entity.Employee;
import com.mks.docker.debugging.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/{dept}")
    public ResponseEntity<List<Employee>> getEmployeeByDept(@PathVariable String dept) {
        List<Employee> employeeList = employeeRepo.getAllEmployee().stream().filter(employee -> dept.equals(employee.dept())).toList();
        return ResponseEntity.ok(employeeList);
    }


    @GetMapping("/notif/{dept}")
    public ResponseEntity<List<String>> getEmployeeEmail(@PathVariable String dept){
        return ResponseEntity.ok(employeeRepo.getAllEmails(dept));
    }

}
