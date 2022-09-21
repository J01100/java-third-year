package com.mabuti.hope.techServ;

import com.mabuti.hope.domain.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeDA {
    ArrayList<Employee> employeeList = new ArrayList<>();

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public EmployeeDA() throws IOException {
            String empRow;
            BufferedReader empFile = new BufferedReader(new FileReader("EMPFILE.csv"));

            try {
                while ((empRow = empFile.readLine()) != null) {
                    String[] empRowSpecific = empRow.split(",");

                    Employee employee = new Employee();

                    employee.setEmpNo(empRowSpecific[0]);
                    employee.setLastName(empRowSpecific[1]);
                    employee.setFirstName(empRowSpecific[2]);
                    employee.setGender(empRowSpecific[3]);

                    employeeList.add(employee);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
