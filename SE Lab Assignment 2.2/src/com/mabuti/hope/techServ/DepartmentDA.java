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
