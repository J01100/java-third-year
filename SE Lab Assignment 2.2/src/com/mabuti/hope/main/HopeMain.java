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
