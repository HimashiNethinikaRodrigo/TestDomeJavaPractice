package main.edu.testdome.java;
/*
A playlist is considered a repeating playlist if
any of the songs contain a reference to a previous song in the playlist.
Otherwise, the playlist will end with the last song which points to null.

Implement a function isRepeatingPlaylist that,
efficiently with respect to time used, returns true if a playlist is repeating or false if it is not.

For example, the following code prints "true" as both songs point to each other.

Song first = new Song("Hello");
Song second = new Song("Eye of the tiger");

first.setNextSong(second);
second.setNextSong(first);

System.out.println(first.isRepeatingPlaylist());
 */
public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    //Floyd Cycle detection
    public boolean isRepeatingPlaylist() {
        Song slow = this;
        Song fast = this;

        // Empty and one element lists have no cycles:
        if (slow == null || slow.nextSong == null) return false;

        // Keep going until there are elements in list
        while (fast != null && fast.nextSong != null)
        {
            slow = slow.nextSong; // one hop
            fast = fast.nextSong.nextSong; // two hop

            // slow can meet the fast only in a loop!
            if (slow == fast) return true;
        }
        //fast found the end of the list. No loops
        return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}
