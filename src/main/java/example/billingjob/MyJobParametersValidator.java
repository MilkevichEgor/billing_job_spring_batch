package example.billingjob;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

public class MyJobParametersValidator implements JobParametersValidator {

    @Override
    public void validate(JobParameters parameters) throws JobParametersInvalidException {
        String inputFile = parameters.getString("input.file");
        if (inputFile == null || inputFile.isEmpty()) {
            throw new JobParametersInvalidException("input.file is required");
        }
    }
}
