package com.hope.techServ;

import com.hope.domain.Department;
import com.hope.domain.Job;
import com.hope.domain.JobHistory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JobHistDA {
    ArrayList<JobHistory> jobHistories = new ArrayList<>();

    public ArrayList<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public JobHistDA(String empNo) throws IOException {
        BufferedReader jobHistFile = new BufferedReader(new FileReader("src/csv/JOBHISTFILE.csv"));

        String jobHistRow;

        while ((jobHistRow = jobHistFile.readLine())!=null) {
            String[] jobHistRowSpecific = jobHistRow.split(",");

            JobHistory jobHist = new JobHistory();

            if (empNo.equals(jobHistRowSpecific[0])){
                jobHist.setSalary(Double.parseDouble(jobHistRowSpecific[3]));
                jobHist.setEffectiveDate(jobHistRowSpecific[2]);

                JobDA jobDA = new JobDA(jobHistRowSpecific[1]);
                jobHist.setJob((Job) jobDA.getJobList());

                DepartmentDA departmentDA = new DepartmentDA(jobHistRowSpecific[4]);
                jobHist.setDepartment((Department) departmentDA.getDepartmentList());

                jobHistories.add(jobHist);
            }
        }
    }
}
