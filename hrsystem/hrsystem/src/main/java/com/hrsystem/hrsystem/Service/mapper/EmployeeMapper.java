package com.hrsystem.hrsystem.Service.mapper;
import com.hrsystem.hrsystem.entity.Department;
import com.hrsystem.hrsystem.entity.Employee;
import com.hrsystem.hrsystem.entity.Team;
import com.hrsystem.hrsystem.entity.command.EmployeeCommand;
import com.hrsystem.hrsystem.entity.dto.EmployeeDto;
import com.hrsystem.hrsystem.repostiory.DepartmentRepository;
import com.hrsystem.hrsystem.repostiory.EmployeeRepository;
import com.hrsystem.hrsystem.repostiory.TeamRepository;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    @Autowired
    ModelMapper modelMapper ;
    @Autowired
    EmployeeRepository employeeRepository ;
//    @Autowired
//    private DepartmentRepository departmentRepository ;
//    @Autowired
//    private TeamRepository teamRepositoryRepository ;

    public Employee employeeComandConvertToEntity (EmployeeCommand employeeCommand){
        modelMapper.getConfiguration().setAmbiguityIgnored( true );
       Employee employee= modelMapper.map(employeeCommand ,Employee.class);
       return employee ;
    }
    public EmployeeDto employeeConvertToEmployeeDto (Employee employee , EmployeeCommand employeeCommand){
        EmployeeDto employeeDto = new EmployeeDto() ;
        employeeDto.setFname( employee.getFname() );
        employeeDto.setLname(employee.getLname());
        employeeDto.setGrossSallary( employee.getGrossSallary() );
        Department department = employee.getDepartmentId();
        int dept_id = department.getId();
        employeeDto.setDepartmentid(dept_id);
        Team team = employee.getTeam();
        int team_id = team.getId();
        employeeDto.setTeamid( team_id );
        Employee manager = employeeRepository.findById(employeeCommand.getManagerid()).get();
        int manager_id= manager.getId();
        employeeDto.setManagerid(manager_id);
        employeeDto.setBirthDate(employee.getBirthDate());
        employeeDto.setStartWorkDate(employee.getStartWorkDate());
        employeeDto.setGraduationDate(employee.getGraduationDate(  ));
        employeeDto.setSetOfExperties( employee.getSetOfExperties() );
        return employeeDto ;
    }
    public EmployeeDto employeeEntityConvertToDto (Employee employee){
        modelMapper.getConfiguration().setAmbiguityIgnored( true );
        EmployeeDto employeeDto= modelMapper.map(employee ,EmployeeDto.class);
        return employeeDto ;
    }
    /*public Employee employeeHandler(EmployeeCommand employeeCommand) {
        Employee employee= new Employee() ;
        EmployeeMapper employeeMapper = new EmployeeMapper();
        Integer dept_id= employeeCommand.getDepartmentid();
        Integer team_id = employeeCommand.getTeamid();
        Integer manag_id = employeeCommand.getManagerid();
        Department department= departmentRepository.findById(dept_id).get();
        Team team = teamRepositoryRepository.findById(team_id).get();
        Employee manager = employeeRepository.findById( manag_id ).get();
        employee = employeeMapper.employeeComandConvertToEntity(employeeCommand);
        employee.setDepartment(department);
        employee.setTeam(team);
        employee.setManager( manager );
        return employee ;
    }*/
}
