package com.mabuti.hope.domain;

public class JobHistory {
    String jobCode;
    Double salary;
    String effectiveDate;
    String empNo;
    Job job;
    Department department;

    public String getJobCode() { return jobCode; }

    public String getEmpNo() { return empNo; }

    public void setEmpNo(String empNo) { this.empNo = empNo; }

    public void setJobCode(String jobCode) { this.jobCode= jobCode; }

    public Job getJob() { return job; }

    public void setJob(Job job) { this.job = job; }

    public Department getDepartment() { return this.department; }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
