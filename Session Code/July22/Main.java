package July22;

public class Main {
    public static void main(String[] args) {
        MusicPlaylist musicPlaylist = new MusicPlaylist();
        Song song1 = new Song("Title 1", "Artist 1", 3.0);
        Song song2 = new Song("Title 2", "Artist 2", 4.2);
        Song song3 = new Song("Title 3", "Artist 3", 2.5);
        Song song4 = new Song("Title 4", "Artist 4", 4.5);
        Song song5 = new Song("Title 5", "Artist 5", 2.5);
        Song song6 = new Song("Title 6", "Artist 6", 2.8);
        Song song7 = new Song("Title 7", "Artist 7", 3.5);


        musicPlaylist.addSongAtBeginning(song1);
        musicPlaylist.addSongAtBeginning(song2);
        musicPlaylist.addSongAtBeginning(song4);
        musicPlaylist.addSongAtBeginning(song5);
        musicPlaylist.addSongAtBeginning(song6);
        musicPlaylist.addSongAtBeginning(song7);
        musicPlaylist.addSongAtEnd(song3);

        musicPlaylist.removeSongByTitle("title 1");
        musicPlaylist.removeSongsByArtist("artist 4");

        musicPlaylist.playCurrentSong();
        musicPlaylist.playNextSong();
        musicPlaylist.playNextSong();
        musicPlaylist.playPreviousSong();

        musicPlaylist.searchAndPlay("title 3");
        musicPlaylist.shufflePlaylist();
        musicPlaylist.displayPlaylist();

        musicPlaylist.createAndPlayCustomPlaylist(10);
    }
}
