package example.billingjob;

import org.springframework.batch.core.*;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.JobParameters;


public class BillingJob implements Job {

    private JobRepository jobRepository;

    public BillingJob(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public String getName() {
        return "BillingJob";
    }

    @Override
    public void execute(JobExecution execution) {
        JobParameters jobParameters = execution.getJobParameters();
        String inputFile = jobParameters.getString("input.file");
        System.out.println("processing billing information " + inputFile);

        execution.setStatus(BatchStatus.COMPLETED);
        execution.setExitStatus(ExitStatus.COMPLETED);
        this.jobRepository.update(execution);
    }
}