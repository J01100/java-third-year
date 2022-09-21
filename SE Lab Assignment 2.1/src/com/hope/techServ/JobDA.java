package com.hope.techServ;

import com.hope.domain.Job;
import com.hope.domain.JobHistory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobDA {
    private final List<Job> jobList = new ArrayList<>();

    public List<Job> getJobList(){
        return jobList;
    }

    public JobDA(String jobCode) throws IOException {
        BufferedReader jobFile = new BufferedReader(new FileReader("src/csv/JOBFILE.csv"));
        String jobRow;

        while ((jobRow = jobFile.readLine())!= null){
            String[] jobRowSpecific = jobRow.split(",");

            if (jobCode.equals(jobRowSpecific[0])){
                Job job = new Job();
                job.setJobCode(jobRowSpecific[0]);
                job.setDescription(jobRowSpecific[1]);

                JobHistory jobHistory = new JobHistory();
                jobHistory.setJob(job);

                jobList.add(job);
            }
        }
    }
}
