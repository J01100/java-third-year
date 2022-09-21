package com.mabuti.hope.techServ;

import com.mabuti.hope.domain.Department;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DepartmentDA {
    ArrayList<Department> departments = new ArrayList<>();

    public ArrayList<Department> getDepartments() { return departments; }

    public DepartmentDA() throws IOException {
        String departmentRow;
        BufferedReader departmentFile = new BufferedReader(new FileReader("DEPFILE.csv"));

        try {
            while ((departmentRow = departmentFile.readLine()) != null) {
                String[] departmentRowSpecific = departmentRow.split(",");

                Department department = new Department();
                department.setDeptCode(departmentRowSpecific[0]);
                department.setDepartmentName(departmentRowSpecific[1]);

                departments.add(department);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
