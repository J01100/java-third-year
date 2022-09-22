package com.mabuti.hope.techServ;

import com.mabuti.hope.domain.Job;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JobDA {
    private Job job = new Job();

    public JobDA (String jobCode) throws IOException {
        BufferedReader jobFile = new BufferedReader(new FileReader("src/csv/JOBFILE.csv"));
        String jobRow;

        while ((jobRow = jobFile.readLine()) != null) {
            String[] jobRowSpecific = jobRow.split(",");
            if (jobCode.contentEquals(jobRowSpecific[0])){
                this.job.setJobCode(jobRowSpecific[0]);
                this.job.setDescription(jobRowSpecific[1]);
            }
        }
    }

    public Job getJob() {
        return job;
    }
}
