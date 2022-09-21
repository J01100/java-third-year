package hope.com.techServ;

import hope.com.domain.Department;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DepartmentDA {
    Department department = new Department();

    public DepartmentDA(String deptCode) throws IOException {
        BufferedReader departmentFile = new BufferedReader(new FileReader("src/csv/DEPFILE.csv"));
        String departmentRow;

        while ((departmentRow = departmentFile.readLine()) != null ) {
            String[] departmentRowSpecific = departmentRow.split(",");

            if (deptCode.contentEquals(departmentRowSpecific[0])){
                department.setDeptCode(departmentRowSpecific[0]);
                department.setDepartmentName(departmentRowSpecific[1]);
            }
        }
    }

    public Department getDepartment() {
        return department;
    }
}
