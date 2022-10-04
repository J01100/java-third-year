package com.mabuti.hope.main;

import com.mabuti.hope.domain.Employee;
import com.mabuti.hope.domain.JobHistory;
import com.mabuti.hope.techServ.EmployeeDA;

import java.io.IOException;

public class HopeMain {
    EmployeeDA employeeDA = new EmployeeDA();

    public HopeMain() throws IOException {
        for (Employee employee : employeeDA.getEmployeeList()){
            System.out.println("\n-----------------------------------------------------\n" +
                                    "EmpCode LastName FirstName Gender");
            System.out.println(employee.getEmpNo() + "\t" +
                                employee.getLastName() + "\t" +
                                employee.getFirstName() + "\t\t" +
                                employee.getGender());

            System.out.println("Job History of Employee:");
            for (JobHistory jobHistory : employee.getJobHistory()){
                System.out.println( jobHistory.getEffectiveDate() + " " +
                                    jobHistory.getSalary() + " " +
                                    jobHistory.getJob().getJobCode() + " " +
                                    jobHistory.getJob().getDescription() + " " +
                                    jobHistory.getDepartment().getDeptCode() + " " +
                                    jobHistory.getDepartment().getDepartmentName() );
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new HopeMain();
    }
}


package com.mabuti.hope.domain;

public class Department {
    private String deptCode, departmentName;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}


package com.mabuti.hope.domain;

import java.util.List;

public class Employee {
    private String empNo, lastName, firstName, gender;

    private List<JobHistory> jobHistory;

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

    public List<JobHistory> getJobHistory() {
        return jobHistory;
    }

    public void setJobHistory(List<JobHistory> jobHistory) {
        this.jobHistory = jobHistory;
    }
}


package com.mabuti.hope.domain;

public class Job {
    private String jobCode, description;

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


package com.mabuti.hope.domain;

public class JobHistory {
    private Job job;
    private Department department;
    private Double salary;
    private String effectiveDate;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Department getDepartment() {
        return department;
    }

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


package com.mabuti.hope.techServ;

import com.mabuti.hope.domain.Department;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DepartmentDA {
    private Department department = new Department();

    public DepartmentDA(String deptCode) throws IOException {
        BufferedReader departmentFile = new BufferedReader(new FileReader("src/csv/DEPFILE.csv"));
        String departmentRow;

        while ((departmentRow = departmentFile.readLine()) != null ) {
            String[] departmentRowSpecific = departmentRow.split(",");

            if (deptCode.contentEquals(departmentRowSpecific[0])){
                this.department.setDeptCode(departmentRowSpecific[0]);
                this.department.setDepartmentName(departmentRowSpecific[1]);
            }
        }
    }

    public Department getDepartment() {
        return department;
    }
}


package com.mabuti.hope.techServ;

import com.mabuti.hope.domain.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDA {
    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeDA() throws IOException {
        BufferedReader empFile = new BufferedReader(new FileReader("src/csv/EMPFILE.csv"));
        String empRow;

        while ((empRow = empFile.readLine()) != null){
            String[] empRowSpecific = empRow.split(",");

            Employee employee = new Employee();

            employee.setEmpNo(empRowSpecific[0]);
            employee.setLastName(empRowSpecific[1]);
            employee.setFirstName(empRowSpecific[2]);
            employee.setGender(empRowSpecific[3]);

            JobHistoryDA jobHistoryDA = new JobHistoryDA(employee.getEmpNo());
            employee.setJobHistory(jobHistoryDA.getJobHistoryList());

            employeeList.add(employee);
        }
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}


package com.mabuti.hope.techServ;

import com.mabuti.hope.domain.Job;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JobDA {
    private Job job = new Job();

    public JobDA (String jobCode) throws IOException {
        BufferedReader jobFile = new BufferedReader(new FileReader("src/csv/JOBFILE.csv"));
        String jobRow;

        while ((jobRow = jobFile.readLine()) != null) {
            String[] jobRowSpecific = jobRow.split(",");
            if (jobCode.contentEquals(jobRowSpecific[0])){
                this.job.setJobCode(jobRowSpecific[0]);
                this.job.setDescription(jobRowSpecific[1]);
            }
        }
    }

    public Job getJob() {
        return job;
    }
}


package com.mabuti.hope.techServ;

import com.mabuti.hope.domain.JobHistory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobHistoryDA {
    private List<JobHistory> jobHistoryList = new ArrayList<>();

    public JobHistoryDA(String empNo) throws IOException {
        BufferedReader jobHistoryFile = new BufferedReader(new FileReader("src/csv/JOBHISTFILE.csv"));

        String jobHistoryRow;
        while ((jobHistoryRow = jobHistoryFile.readLine()) != null){
            String[] jobHistoryRowSpecific = jobHistoryRow.split(",");
            JobHistory jobHistory = new JobHistory();

            if (jobHistoryRowSpecific[0].contentEquals(empNo)){
                jobHistory.setEffectiveDate(jobHistoryRowSpecific[2]);
                jobHistory.setSalary(Double.parseDouble(jobHistoryRowSpecific[3]));

                JobDA jobDA = new JobDA(jobHistoryRowSpecific[1]);
                jobHistory.setJob(jobDA.getJob());

                DepartmentDA departmentDA = new DepartmentDA(jobHistoryRowSpecific[4]);
                jobHistory.setDepartment(departmentDA.getDepartment());

                jobHistoryList.add(jobHistory);
            }
        }
    }

    public List<JobHistory> getJobHistoryList() {
        return jobHistoryList;
    }

}
