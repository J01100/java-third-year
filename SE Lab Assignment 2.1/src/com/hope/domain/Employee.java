package com.hope.domain;

import java.util.List;

public class Employee {
    private String empNo, lastName, firstName, gender;
    private List<JobHistory> jobHist;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<JobHistory> getJobHist() {
        return jobHist;
    }

    public void setJobHist(List<JobHistory> jobHist) {
        this.jobHist = jobHist;
    }
}
