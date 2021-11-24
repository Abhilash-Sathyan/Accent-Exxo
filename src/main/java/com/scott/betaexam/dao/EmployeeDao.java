package com.scott.betaexam.dao;

import com.scott.betaexam.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,String>

{

    @Query(value = "SELECT employee FROM Employee employee where employee.name LIKE %:search% OR employee.email LIKE %:search% OR employee.addressLine1 LIKE %:search% OR employee.state LIKE %:search% OR employee.city LIKE %:search% OR employee.id LIKE %:search% OR employee.createDate LIKE %:search%" )
    List<Employee> findAll(String search);
}
