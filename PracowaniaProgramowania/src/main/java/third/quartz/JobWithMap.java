package third.quartz;

import org.quartz.*;

@PersistJobDataAfterExecution
public class JobWithMap  implements org.quartz.Job{

    public void execute(JobExecutionContext context) throws JobExecutionException {
        {
            JobKey key = context.getJobDetail().getKey();

            JobDataMap dataMap = context.getJobDetail().getJobDataMap();

            //read values
            String jobSays = dataMap.getString("jobSays");
            int counter = 0;
            if (dataMap.containsKey("counter")) {
                counter = dataMap.getInt("counter");
            }

            System.err.println("Instance " + key + " of says: " + jobSays + " number " + counter);

            counter++;
            //increment and save counter
            dataMap.put("counter", counter);
        }
    }
}
