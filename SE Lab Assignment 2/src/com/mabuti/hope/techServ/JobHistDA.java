package com.mabuti.hope.techServ;

import com.mabuti.hope.domain.Department;
import com.mabuti.hope.domain.Job;
import com.mabuti.hope.domain.JobHistory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobHistDA {
    JobDA jobDA = new JobDA();
    DepartmentDA deptDA = new DepartmentDA();
    List<Job> jobs = jobDA.getJobs();
    List<Department> departments = deptDA.getDepartments();

    ArrayList<JobHistory> jobHist = new ArrayList<>();

    public ArrayList<JobHistory> getJobHist() { return jobHist; }

    public JobHistDA() throws IOException {
        String jobHistRow;
        BufferedReader jobHistFile = new BufferedReader(new FileReader("JOBHISTFILE.csv"));

        try {
            while((jobHistRow = jobHistFile.readLine())!= null){
                String[] jobHistSpecific = jobHistRow.split(",");

                JobHistory jobHistory = new JobHistory();
                jobHistory.setEmpNo(jobHistSpecific[0]);
                jobHistory.setJobCode(jobHistSpecific[1]);
                jobHistory.setEffectiveDate(jobHistSpecific[2]);
                jobHistory.setSalary(Double.parseDouble(jobHistSpecific[3]));

                for (Department department: departments){
                    if (jobHistSpecific[4].equals(department.getDeptCode())){
                        jobHistory.setDepartment(department);
                    }
                }
                jobHist.add(jobHistory);

            }
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

}
