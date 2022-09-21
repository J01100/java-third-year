package com.mabuti.hope.techServ;

import com.mabuti.hope.domain.Job;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JobDA {
    private static ArrayList<Job> jobs = new ArrayList<>();
    public static ArrayList<Job> getJobs() { return jobs; }

    public JobDA() throws IOException {
        String jobRow;
        BufferedReader jobFile = new BufferedReader(new FileReader("JOBFILE.csv"));

        try {
            while((jobRow = jobFile.readLine())!= null){
                String[] jobRowSpecific = jobRow.split(",");

                Job job = new Job();

                job.setJobCode(jobRowSpecific[0]);
                job.setDescription(jobRowSpecific[1]);

                jobs.add(job);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
