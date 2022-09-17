package com.hrsystem.hrsystem.Service;

import com.hrsystem.hrsystem.Service.mapper.EmployeeMapper;
import com.hrsystem.hrsystem.entity.Department;
import com.hrsystem.hrsystem.entity.Employee;
import com.hrsystem.hrsystem.entity.Team;
import com.hrsystem.hrsystem.entity.command.EmployeeCommand;
import com.hrsystem.hrsystem.entity.dto.EmployeeDto;
import com.hrsystem.hrsystem.repostiory.DepartmentRepository;
import com.hrsystem.hrsystem.repostiory.EmployeeRepository;
import com.hrsystem.hrsystem.repostiory.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TeamRepository teamRepositoryRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    public EmployeeDto ADD(EmployeeCommand employeeCommand) {
        Integer dept_id = employeeCommand.getDepartmentid();
        Integer team_id = employeeCommand.getTeamid();
        Integer manag_id = employeeCommand.getManagerid();
        Department department = departmentRepository.findById( dept_id ).get();
        Team team = teamRepositoryRepository.findById( team_id ).get();
        Employee manager = employeeRepository.findById( manag_id ).get();
        Employee employee = employeeMapper.employeeComandConvertToEntity( employeeCommand );
        employee.setDepartment( department );
        employee.setTeam( team );
        employee.setManager( manager );
        // employee = employeeMapper.employeeHandler(employeeCommand);
//        int id =employee.getId();
//        SetOfExperties setOfExperties =new SetOfExperties();
        employee = employeeRepository.save( employee );
        List<Employee> list = new ArrayList<>();
        list.add( employee );
        employee.setEmployees( list );
        EmployeeDto employeeDto = employeeMapper.employeeConvertToEmployeeDto( employee, employeeCommand );
        return employeeDto;
    }
    public Employee getEmployeeByID (Integer employeeid){
       // Employee employee =employeeRepository.findById(id).get();
        //EmployeeDto employeeDto =employeeMapper.employeeEntityConvertToDto(employee) ;
        return employeeRepository.findById(employeeid).get();
    }

    public  Employee updateEmployee(Integer id, Employee newEmployee){
        Employee employee = employeeRepository.findById( id ).get();
        if (employee == null){
            String result = ("employee isnot found");
            return newEmployee ;
        }else
        employee.setDepartment( newEmployee.getDepartmentId());
        employee.setGrossSallary( newEmployee.getGrossSallary() );
        employee.setTeam( newEmployee.getTeam());
        employeeRepository.save( employee );
        return employee ;
    }
}
