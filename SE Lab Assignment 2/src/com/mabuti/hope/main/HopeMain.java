package com.mabuti.hope.main;

import com.mabuti.hope.domain.Department;
import com.mabuti.hope.domain.Employee;
import com.mabuti.hope.domain.Job;
import com.mabuti.hope.domain.JobHistory;
import com.mabuti.hope.techServ.DepartmentDA;
import com.mabuti.hope.techServ.EmployeeDA;
import com.mabuti.hope.techServ.JobDA;
import com.mabuti.hope.techServ.JobHistDA;

import java.io.IOException;
import java.util.List;

// 1.  Continue what is left off in the video. Refer to the data files here.
//
//         2.  You need to display in the final output  the  following:
//
//         a.  Employee number, last name, first name, gender.
//
//         b.  Underneath a, you need to include the effectivity date, job code, job description, salary, department code, department name
//
//         c.  Indicate at least a separator to distinguish one employee's job history from the other employee
//
//         3.  Paste the code in a document file.
//
//         4.  Include screen shots of your output.
//
//         5.  Convert the document file into PDF and upload in this link

public class HopeMain {
    public HopeMain() throws IOException {

        EmployeeDA empDA = new EmployeeDA();
        List<Employee> empList = empDA.getEmployeeList();
        JobHistDA jobHistDA = new JobHistDA();
        List<JobHistory> jobHists = jobHistDA.getJobHist();

        for (Employee employee: empList){
            System.out.println(employee.getEmpNo()+ " " +
                                employee.getLastName()+ " " +
                                employee.getFirstName()+ " " +
                                employee.getGender() );

            for (JobHistory jobHist: jobHists){
                if (jobHist.getEmpNo().equals(employee.getEmpNo())){
                    System.out.println(jobHist.getEffectiveDate() + " " +
                            jobHist.getJobCode() + " " +
                            jobHist.getSalary() + " " +
                            jobHist.getDepartment().getDepartmentName());
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        new HopeMain();
    }
}
