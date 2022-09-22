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
            employee.setJobHist(jobHistoryDA.getJobHistoryList());

            employeeList.add(employee);
        }
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
