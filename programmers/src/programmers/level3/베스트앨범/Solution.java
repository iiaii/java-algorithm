package programmers.level3.베스트앨범;

import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        PriorityQueue<List> genreLists = new PriorityQueue<>(Comparator.comparingInt(List::getTotalPlays).reversed());
        genreLists.addAll(getGenreLists(genres, plays));
        LinkedList<Integer> bestAlbum = new LinkedList<>();
        while(!genreLists.isEmpty()) {
            List genreList = genreLists.poll();
            bestAlbum.add(genreList.getSongs().poll().getId());
            if(!genreList.getSongs().isEmpty()) {
                bestAlbum.add(genreList.getSongs().poll().getId());
            }
        }
        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }

    public Collection<List> getGenreLists(String[] genres, int[] plays) {
        HashMap<String, List> genreLists = new HashMap<>();
        for (int i = 0; i < genres.length ; i++) {
            List list = genreLists.getOrDefault(genres[i], new List());
            list.addSongs(new Song(i, plays[i]));
            genreLists.put(genres[i], list);
        }
        return genreLists.values();
    }
}

class List {
    private int totalPlays;
    private PriorityQueue<Song> songs;

    public List() {
        this.totalPlays = 0;
        this.songs = new PriorityQueue<>((a, b) -> {
            if(a.getPlays() == b.getPlays()) {
                return a.getId()-b.getId();
            }
            return b.getPlays()-a.getPlays();
        });
    }

    public int getTotalPlays() {
        return totalPlays;
    }

    public PriorityQueue<Song> getSongs() {
        return songs;
    }

    public void addSongs(Song song) {
        songs.add(song);
        totalPlays += song.getPlays();
    }
}

class Song {
    private int id;
    private int plays;

    public Song(int id, int plays) {
        this.id = id;
        this.plays = plays;
    }

    public int getId() {
        return id;
    }

    public int getPlays() {
        return plays;
    }
}
