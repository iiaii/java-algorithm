package programmers.level3.추석트래픽;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.PriorityQueue;

public class Solution {
    public PriorityQueue<Log> timeline = new PriorityQueue<>((a,b) -> (int)(a.getTime()-b.getTime()));
    public int solution(String[] lines) {
        for (String line : lines) {
            String[] data = line.split(" ");
            addToTimeline(data[1], data[2].replace("s",""));
        }
        int max = 0;
        int curLogs = 0;
        while (!timeline.isEmpty()) {
            Log log = timeline.poll();
            if(log.getState() == State.START) {
                curLogs++;
                continue;
            }
            max = Math.max((curLogs--)+getNextLogs(timeline.toArray(Log[]::new), log.getTime()), max);
        }
        return max;
    }

    public int getNextLogs(Log[] logs, long startTime) {
        int count = 0;
        for (Log log : logs) {
            count += log.getState() == State.START && log.getTime() < startTime+1000 ? 1 : 0;
        }
        return count;
    }

    public void addToTimeline(String Time, String executionTime) {
        try {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
            long endTime = timeFormat.parse(Time).getTime();
            long startTime = endTime - (long)(Double.parseDouble(executionTime)*1000)+1;
            timeline.add(new Log(State.START, startTime));
            timeline.add(new Log(State.END, endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

class Log {
    private State state;
    private long time;

    public Log(State state, long time) {
        this.state = state;
        this.time = time;
    }

    public State getState() {
        return state;
    }

    public long getTime() {
        return time;
    }
}

enum State {
    START, END
}