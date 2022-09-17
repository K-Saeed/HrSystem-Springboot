package com.hrsystem.hrsystem.controller;

import com.hrsystem.hrsystem.Service.EmployeeService;
import com.hrsystem.hrsystem.entity.Employee;
import com.hrsystem.hrsystem.entity.command.EmployeeCommand;
import com.hrsystem.hrsystem.entity.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

    @Autowired(required = true)
    private EmployeeService employeeService;

    @GetMapping (value = "/add")
    public @ResponseBody EmployeeDto addNewEmployee (@RequestBody EmployeeCommand employeeCommand) {
        return employeeService.ADD(employeeCommand);
    }
    @GetMapping  (value ="/get/employeeid")
    public @ResponseBody Employee findEmployeeByID (@PathVariable ("employeeid") Integer employeeid){
        return employeeService.getEmployeeByID(employeeid);
    }
    @GetMapping (value = "/add")
    public @ResponseBody  Employee updateEmployee (@PathVariable ("employeeid") Integer employeeid , Employee employee) {
        return employeeService.updateEmployee( employeeid,employee );
    }


}
