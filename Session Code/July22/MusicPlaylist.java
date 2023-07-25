package July22;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MusicPlaylist {
    private final LinkedList<Song> songs;
    private int currentSongIndex;

    public MusicPlaylist() {
        songs = new LinkedList<>();
        currentSongIndex = -1;
    }

    public void addSongAtBeginning(Song song) {
        songs.addFirst(song);
        System.out.println(song + " added to the playlist at the beginning");
    }

    public void addSongAtEnd(Song song) {
        songs.addLast(song);
        System.out.println(song + " added to the playlist at last");
    }

    public void removeSongByTitle(String title) {
        songs.removeIf(song -> song.getTitle().equalsIgnoreCase(title));
        System.out.println(title.toUpperCase() + " removed from the playlist");
    }

    public void removeSongsByArtist(String artist) {
        songs.removeIf(song -> song.getArtist().equalsIgnoreCase(artist));
        System.out.println("Songs by " + artist + " removed from the playlist");
    }

    public void playCurrentSong() {
        if (currentSongIndex >= 0 && currentSongIndex < songs.size()) {
            Song currentSong = songs.get(currentSongIndex);
            System.out.println("Playing " + currentSong);
        } else {
            System.out.println("No song is currently playing.");
        }
    }

    public void playNextSong() {
        if (currentSongIndex < songs.size() - 1) {
            currentSongIndex++;
            playCurrentSong();
        } else {
            System.out.println("End of Playlist.");
        }
    }

    public void playPreviousSong() {
        if (currentSongIndex > 0 && currentSongIndex < songs.size()) {
            currentSongIndex--;
            playCurrentSong();
        } else {
            System.out.println("No previous songs. At the beginning of the playlist");
        }
    }

    public void displayPlaylist() {
        int i = 1;
        for (Song song : songs) {
            System.out.println(i + " " + song);
            i++;
        }
    }

    public void shufflePlaylist() {
        Collections.shuffle(songs);
    }

    public void searchAndPlay(String searchQuery) {
        Map<String, Song> songMap = new HashMap<>();
        for (Song song : songs) {
            songMap.put(song.getTitle().toLowerCase(), song);
            songMap.put(song.getArtist().toLowerCase(), song);
        }

        Song foundSong = songMap.get(searchQuery.toLowerCase());
        if (foundSong != null) {
            currentSongIndex = songs.indexOf(foundSong);
            playCurrentSong();
        } else {
            System.out.println("Song with title or artist matching \"" + searchQuery + "\" not found.");
        }
    }

    public void createAndPlayCustomPlaylist(double durationLimit) {
        LinkedList<Song> customPlaylist = new LinkedList<>();
        double duration = 0;

        for (Song song : songs) {
            if (duration + song.getDuration() <= durationLimit) {
                customPlaylist.add(song);
                duration += song.getDuration();
            } else {
                break;
            }
        }

        System.out.println("Custom Playlist: ");
        int i = 1;
        for (Song song : customPlaylist) {
            System.out.println(i + " " + song.getTitle());
            i++;
        }
    }
}
