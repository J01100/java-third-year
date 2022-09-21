package hope.com.main;

import hope.com.domain.Employee;
import hope.com.domain.JobHistory;
import hope.com.techServ.EmployeeDA;

import java.io.IOException;

public class HopeMain {
    EmployeeDA employeeDA = new EmployeeDA();

    public HopeMain() throws IOException {
        for (Employee employee : employeeDA.getEmployeeList()){
            System.out.println(employee.getEmpNo() + " " +
                                employee.getLastName() + " " +
                                employee.getFirstName() + " " +
                                employee.getGender());

            for (JobHistory jobHistory : employee.getJobHist()){
                System.out.println(jobHistory.getEffectiveDate() + " " +
                                    jobHistory.getJob().getJobCode() + " " +
                                    jobHistory.getJob().getDescription() + " " +
                                    jobHistory.getSalary());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new HopeMain();
    }
}
