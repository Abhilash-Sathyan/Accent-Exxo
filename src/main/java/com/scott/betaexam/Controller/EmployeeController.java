package com.scott.betaexam.Controller;

import com.scott.betaexam.Model.Employee;
import com.scott.betaexam.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    List<Employee> employee1=new ArrayList<Employee>();
    List<Employee> employee2=new ArrayList<Employee>();
    @PostMapping("/addEmployee")
    private ResponseEntity<List<Employee>> addEmployeeDetails(@RequestBody Employee employee)
    {
        LocalDateTime date = LocalDateTime.now();
        UUID uuid=UUID.randomUUID();
        String uuid1=uuid.toString();
        String date1=date.toString();
        employee.setId(uuid1);
        employee.setCreateDate(date1);
        employeeDao.save(employee);
        employee1=employeeDao.findAll();
        return ResponseEntity.ok(employee1);

    }
@GetMapping("/getDetails")
    public List<Employee> getEmployees(@RequestParam("search") String search)
{
    System.out.println("the param value"+search);
    employee2=employeeDao.findAll(search);
    return employee2;
}
}
