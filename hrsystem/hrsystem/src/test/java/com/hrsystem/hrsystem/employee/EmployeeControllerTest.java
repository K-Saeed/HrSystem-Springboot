package com.hrsystem.hrsystem.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrsystem.hrsystem.Service.EmployeeService;
import com.hrsystem.hrsystem.controller.EmployeeController;
import com.hrsystem.hrsystem.entity.Department;
import com.hrsystem.hrsystem.entity.Employee;
import com.hrsystem.hrsystem.entity.command.EmployeeCommand;
import com.hrsystem.hrsystem.entity.dto.EmployeeDto;
import com.hrsystem.hrsystem.repostiory.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.*;

import javax.transaction.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ExtendWith ({SpringExtension.class})
public class EmployeeControllerTest {


    @Autowired
    private EmployeeController employeeController;
    @Autowired
    private EmployeeRepository employeeRepository ;
    @Autowired
    ObjectMapper objectMapper ;
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    EmployeeService employeeService ;


    @Test
    void contextLoads() {
    }
    @Test
    public void whenSaveUser_shouldReturnUser() {
        EmployeeCommand employee =new EmployeeCommand(null,"saeed",3000,1,1,1,new ArrayList<>(),new Date( 1996-8-01 ),new Date( 1996-8-01 ),new Date( 1996-8-01 ));
        employee.setFname("Test Name");
        EmployeeDto created = employeeService.ADD(employee);
        Assertions.assertThat(created.getFname()).isSameAs(employee.getFname());
    }

    @Test
    public void addUserTest() throws Exception {
        EmployeeCommand employeeCommand =new EmployeeCommand("khaled","saeed",3000,1,1,1,new ArrayList<>(),new Date( 1996-8-01 ),new Date( 1996-8-01 ),new Date( 1996-8-01 ));
        Department department = new Department(1,"dt");
       // Team team = new Team(1,"Khaled");
        mockMvc.perform( MockMvcRequestBuilders.post("/employee/add").accept( MediaType.APPLICATION_JSON)
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(objectMapper .writeValueAsString(employeeCommand)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fname").value("khaled"))
                .andExpect(jsonPath("$.lname").value("saeed"))
                .andExpect(jsonPath("$.grossSallary").value(3000))
                .andExpect(jsonPath("$.departmentid").value(1))
                .andExpect(jsonPath("$.managerid").value(1))
                .andExpect(jsonPath("$.managerid").value(1))
                .andExpect(jsonPath( "$.birthDate").value(1996-8-01))
                .andExpect(jsonPath( "$.graduationDate").value(1996-8-01))
                .andExpect(jsonPath( "$.startWorkDate").value(1996-8-01));
    }
    @Test 
    void  whenNullValue_thenReturns400AndErrorResult () throws Exception {
        EmployeeCommand employeeCommand = null;
        mockMvc.perform( MockMvcRequestBuilders.post("/employee/add").accept( MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper .writeValueAsString(employeeCommand)))
                .andExpect(status().isBadRequest());
    }
    @Test
    void getEmployeTest () throws Exception {
        Integer id = 1 ;
        mockMvc.perform( MockMvcRequestBuilders.post("/employee/get-by-id").accept( MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper .writeValueAsString(id)))
                .andExpect(status().isOk());

    }
    @Test
    void findEmployeeTest2 () throws Exception {
        Integer id = 200 ;
        mockMvc.perform( MockMvcRequestBuilders.post("/employee/get-by-id").accept( MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper .writeValueAsString(id)))
                .andExpect(status().isBadRequest());
    }
    @Test
    void findEmployeeTest3 () throws Exception {
       Integer id = 64;
        mockMvc.perform( MockMvcRequestBuilders.post("/employee/add").accept( MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper .writeValueAsString(id)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fname").value("khaled"))
                .andExpect(jsonPath("$.lname").value("saeed"))
                .andExpect(jsonPath("$.grossSallary").value(3000))
                .andExpect(jsonPath("$.departmentid").value(1))
                .andExpect(jsonPath("$.managerid").value(1))
                .andExpect(jsonPath("$.managerid").value(1))
                .andExpect(jsonPath( "$.birthDate").value(1996-8-01))
                .andExpect(jsonPath( "$.graduationDate").value(1996-8-01))
                .andExpect(jsonPath( "$.startWorkDate").value(1996-8-01));
    }
    @Test
    public void whenGivenId_shouldUpdateUser_ifFound() throws Exception {
        Employee employee = new Employee();
        employee.setId(89);
        employee.setFname("Test Name");

        Employee newEmployee = new Employee();
        employee.setFname("New Test Name");

        given(employeeRepository.findById(employee.getId())).willReturn( Optional.of(employee));
        employeeService.updateEmployee(employee.getId(), newEmployee);

        Mockito.verify(employeeRepository).save(newEmployee);
        Mockito.verify(employeeRepository).findById(employee.getId());
    }
    @Test
    public void should_t1J2WMuE8JJeN5WsA1v8DxhXBezXy1STMy3() throws Exception {
        Employee employee = new Employee();
        employee.setId(89);
        employee.setFname("Test Name");

        Employee newUser = new Employee();
        newUser.setId(90);
        employee.setFname("New Test Name");

        given(employeeRepository.findById( ArgumentMatchers.anyInt())).willReturn(Optional.ofNullable(null));
        employeeService.updateEmployee(employee.getId(), newUser);
    }


}
