package Demo;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecentlyPlayedSongs {
    private List<String> playlist;
    private int capacity;

    public RecentlyPlayedSongs(int capacity) {
        this.playlist = new ArrayList<>();
        this.capacity = capacity;
    }

    public void playSong(String song) {
        if (playlist.contains(song)) {
            playlist.remove(song);
        }
        playlist.add(0, song);
        if (playlist.size() > capacity) {
            playlist.remove(capacity);
        }
    }

    public void displayPlaylist() {
        System.out.print("The playlist would look like -> ");
        for (String song : playlist) {
            System.out.print(song + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial songs (comma-separated): ");
        String initialSongsInput = scanner.nextLine();
        String[] initialSongs = initialSongsInput.split(",");

        RecentlyPlayedSongs store = new RecentlyPlayedSongs(initialSongs.length);
        for (String song : initialSongs) {
            store.playSong(song.trim());
        }

        store.displayPlaylist();

        while (true) {
            System.out.print("Enter a song to play (or 'exit' to quit): ");
            String song = scanner.nextLine();

            if (song.equalsIgnoreCase("exit")) {
                break;
            }

            store.playSong(song.trim());
            store.displayPlaylist();
        }

        scanner.close();
    }
}



