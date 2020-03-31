package programmers.level3.디스크컨트롤러;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> sortedJobs = sortJobs(jobs);
        PriorityQueue<Job> diskController = new PriorityQueue<>(Comparator.comparingInt(Job::getRequiredTime));
        int turnaroundTimes = 0;
        int currentTime = 0;
        while(!(sortedJobs.isEmpty() && diskController.isEmpty())) {
            if(isAddableTime(sortedJobs, currentTime)) {
                diskController.add(sortedJobs.poll());
                continue;
            }
            if(diskController.isEmpty()) {
                currentTime = sortedJobs.peek().getStartTime();
                continue;
            }
            Job job = diskController.poll();
            currentTime += job.getRequiredTime();
            turnaroundTimes += currentTime-job.getStartTime();
        }
        return turnaroundTimes/jobs.length;
    }

    public PriorityQueue<Job> sortJobs(int[][] jobs) {
        PriorityQueue<Job> sortedJobs = new PriorityQueue<>(Comparator.comparingInt(Job::getStartTime));
        for (int[] job : jobs) {
            sortedJobs.add(new Job(job[0], job[1]));
        }
        return sortedJobs;
    }

    public boolean isAddableTime(PriorityQueue<Job> allJobs, int currentTime) {
        return !allJobs.isEmpty() && currentTime >= allJobs.peek().getStartTime();
    }
}

class Job {
    private int startTime;
    private int requiredTime;

    public Job(int startTime, int requiredTime) {
        this.startTime = startTime;
        this.requiredTime = requiredTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getRequiredTime() {
        return requiredTime;
    }
}
