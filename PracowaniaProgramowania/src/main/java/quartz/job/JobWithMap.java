package quartz.job;

import org.quartz.*;

@PersistJobDataAfterExecution
public class JobWithMap  implements org.quartz.Job{

    public void execute(JobExecutionContext context) throws JobExecutionException {
        {
            //Job name
            JobKey key = context.getJobDetail().getKey();

            //Job values Map
            JobDataMap dataMap = context.getJobDetail().getJobDataMap();

            //read values
            String jobSays = dataMap.getString("jobSays");

            int counter = 0;
            if (dataMap.containsKey("counter")) {
                counter = dataMap.getInt("counter");
            }

            //Print on the screen
            System.err.println("Instance " + key + " of says: " + jobSays + " number " + counter);

            counter++;

            //increment and save counter
            dataMap.put("counter", counter);
        }
    }
}
