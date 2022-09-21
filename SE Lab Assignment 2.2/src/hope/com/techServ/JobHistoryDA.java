package hope.com.techServ;

import hope.com.domain.JobHistory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobHistoryDA {
    private List<JobHistory> jobHistoryList = new ArrayList<>();

    public JobHistoryDA(String empNo) throws IOException {
        BufferedReader jobHistoryFile = new BufferedReader(new FileReader("src/csv/JOBHISTFILE.csv"));

        String jobHistoryRow;
        while ((jobHistoryRow = jobHistoryFile.readLine()) != null){
            String[] jobHistoryRowSpecific = jobHistoryRow.split(",");
            JobHistory jobHistory = new JobHistory();

            if (jobHistoryRowSpecific[0].contentEquals(empNo)){
                jobHistory.setEffectiveDate(jobHistoryRowSpecific[2]);
                jobHistory.setSalary(Double.parseDouble(jobHistoryRowSpecific[3]));

                JobDA jobDA = new JobDA(jobHistoryRowSpecific[1]);
                jobHistory.setJob(jobDA.getJob());
                DepartmentDA departmentDA = new DepartmentDA();

                jobHistoryList.add(jobHistory);
            }
        }
    }

    public List<JobHistory> getJobHistoryList() {
        return jobHistoryList;
    }

}
