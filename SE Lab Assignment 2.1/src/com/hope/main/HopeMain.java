package com.hope.main;

import com.hope.domain.Employee;
import com.hope.domain.JobHistory;
import com.hope.techServ.EmployeeDA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HopeMain {
    public HopeMain() throws IOException {
        EmployeeDA empDA = new EmployeeDA();
        List<Employee> empList = empDA.getEmployeeList();

        for (Employee employee: empList){
            System.out.println( employee.getEmpNo() + " " +
                                employee.getLastName() + " " +
                                employee.getFirstName() + " " +
                                employee.getGender() );

            for (JobHistory jobHistory: employee.getJobHist()){
                System.out.println(jobHistory.getEffectiveDate() + " " +
                                    jobHistory.getJob().getJobCode() + " " +
                                    jobHistory.getJob().getDescription() + " " +
                                    jobHistory.getSalary() + " " +
                                    jobHistory.getDepartment().getDeptCode() + " " +
                                    jobHistory.getDepartment().getDepartmentName());
            }
        }


    }
    public static void main(String[] args) throws IOException {
        new HopeMain();
    }
}
