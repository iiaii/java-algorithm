package programmers.level2.방금그곡;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.PriorityQueue;

public class Solution {
    public String solution(String m, String[] musicinfos) {
        PriorityQueue<Song> simularSongs = new PriorityQueue<>((a,b) -> b.getPlayTime()-a.getPlayTime());
        for (int i=0 ; i<musicinfos.length ; i++) {
            String[] data = musicinfos[i].split(",");
            int playTime = getPlayTime(data[0], data[1]);
            if (getPlayedMelody(parse(data[3]), playTime).contains(parse(m))) {
                simularSongs.add(new Song(data[2], playTime));
            }
        }
        return simularSongs.isEmpty() ? "(None)" : simularSongs.peek().getName();
    }

    public String parse(String melody) {
        return melody.replaceAll("C#","c")
                .replaceAll("D#","d")
                .replaceAll("F#","f")
                .replaceAll("G#","g")
                .replaceAll("A#","a");
    }

    public int getPlayTime(String startTime, String endTime) {
        int playTime = 0;
        try {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            playTime = (int) (format.parse(endTime).getTime()-format.parse(startTime).getTime())/60000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return playTime;
    }

    public String getPlayedMelody(String songMelody, int playTime) {
        return songMelody.repeat(playTime/songMelody.length())+songMelody.substring(0, playTime%songMelody.length());
    }
}

class Song {
    private String name;
    private int playTime;

    public Song(String name, int playTime) {
        this.name = name;
        this.playTime = playTime;
    }

    public String getName() {
        return name;
    }

    public int getPlayTime() {
        return playTime;
    }
}