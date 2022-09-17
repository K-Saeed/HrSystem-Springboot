package com.hrsystem.hrsystem.entity.command;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsystem.hrsystem.entity.SetOfExperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Date;
import java.util.List;

@Data
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
public class EmployeeCommand {
    private String fname ;
    private String lname ;
    private Integer grossSallary ;
    private Integer departmentid ;
    private Integer teamid;
    private Integer managerid;
    private List<SetOfExperties> setOfExperties;
    private Date birthDate ;
    private Date graduationDate ;
    private Date startWorkDate ;

    public EmployeeCommand(String fname, String lname, int grossSallary, Integer departmentid,
                           Integer teamid, Integer managerid, List <SetOfExperties>setOfExperties,
                           Date birthDate, Date graduationDate, Date startWorkDate) {
        this.fname=fname;
        this.lname=lname;
        this.grossSallary=grossSallary;
        this.departmentid=departmentid;
        this.teamid=teamid;
        this.managerid=managerid;
        this.setOfExperties = setOfExperties;
        this.birthDate = birthDate;
        this.graduationDate = graduationDate;
        this.startWorkDate = startWorkDate;
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

    public void setGrossSallary(Integer grossSallary) {
        this.grossSallary = grossSallary;
    }

    public Integer getGrossSallary() {
        return grossSallary;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
    }

    public Integer getTeamid() {
        return teamid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public Integer getManagerid() {
        return managerid;
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
