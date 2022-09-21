package com.hope.techServ;

import com.hope.domain.Department;
import com.hope.domain.JobHistory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDA {
    List<Department> departmentList = new ArrayList<>();

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public DepartmentDA(String depCode) throws IOException {
        BufferedReader depFile = new BufferedReader(new FileReader("src/csv/DEPFILE.csv"));
        String depRow;

        while ((depRow = depFile.readLine())!= null){
            String[] depRowSpecific = depRow.split(",");

            if (depCode.equals(depRowSpecific[0])){
                Department department = new Department();
                department.setDeptCode(depRowSpecific[0]);

                JobHistory jobHistory = new JobHistory();
                jobHistory.setDepartment(department);

                departmentList.add(department);
            }
        }
    }
}
