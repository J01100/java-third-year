package com.mabuti.hope.domain;

import java.util.List;

public class Employee {
    String empNo;
    String lastName;
    String firstName;
    String gender;
    List<JobHistory> jobHist;

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
}
