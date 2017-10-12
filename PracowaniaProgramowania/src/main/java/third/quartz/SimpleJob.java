package third.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements org.quartz.Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("Executuja mnie");
    }
}
