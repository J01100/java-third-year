package com.hope.techServ;

import com.hope.domain.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDA {
    private final List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    public EmployeeDA() throws IOException {
        BufferedReader empFile = new BufferedReader(new FileReader("src/csv/EMPFILE.csv"));
        String empRow;

        while ((empRow = empFile.readLine())!= null){
            String[] empRowSpecific = empRow.split(",");

            Employee employee = new Employee();

            employee.setEmpNo(empRowSpecific[0]);
            employee.setLastName(empRowSpecific[1]);
            employee.setFirstName(empRowSpecific[2]);
            employee.setGender(empRowSpecific[3]);

            JobHistDA jobHistDA = new JobHistDA(employee.getEmpNo());
            employee.setJobHist(jobHistDA.getJobHistories());

            employeeList.add(employee);
        }
    }
}
