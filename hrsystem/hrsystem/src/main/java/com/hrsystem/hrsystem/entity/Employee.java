package com.hrsystem.hrsystem.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
public class Employee extends Throwable {
    @Id
    @Column(name = "id") @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fname ;
    private String lname ;
    private  Integer grossSallary ;
    private Date birthDate ;
    private Date graduationDate ;
    private Date startWorkDate ;
    @ManyToOne()
    @JoinColumn(name ="teamid" ,referencedColumnName = "id")
    private Team team;
    @ManyToOne
    @JoinColumn(name ="departmentid" ,referencedColumnName = "id")
    private Department department;
    @ManyToOne
    @JoinColumn(name ="managerid" ,referencedColumnName = "id")
    private Employee manager;
    @OneToMany(mappedBy = "manager")
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "id")
    private List <SetOfExperties>setOfExperties;

    public Employee() {
    }

    public Employee(Integer id, String fname, String lname, Integer grossSallary,
                    Team team, Department department, Employee managerId,
                    List<SetOfExperties> setOfExperties,Date birthDate, Date graduationDate, Date startWorkDate){
        this.id=id;
        this.fname=fname;
        this.lname = lname ;
        this.grossSallary = grossSallary;
        this.team = team;
        this.department = department;
        this.manager = managerId;
        this.setOfExperties = setOfExperties;
        this.birthDate = birthDate;
        this.graduationDate = graduationDate;
        this.startWorkDate = startWorkDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartmentId() {
        return department;
    }

    public void setGrossSallary(Integer grossSallary) {
        this.grossSallary = grossSallary;
    }

    public Integer getGrossSallary() {
        return grossSallary;
    }

    public void setTeam(Team team) {
       this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Employee getManager() {
        return manager;
    }

    public List<SetOfExperties> getSetOfExperties() {
        return setOfExperties;
    }

    public void setSetOfExperties(List<SetOfExperties> setOfExperties) {
        this.setOfExperties = setOfExperties;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Date getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }
}
