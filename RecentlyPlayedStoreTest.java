import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class RecentlyPlayedStoreTest {
    private RecentlyPlayedStore store;

    @BeforeMethod
    public void setup() {
        store = new RecentlyPlayedStore(3);
    }

    //This test method adds songs for different users and verifies recently played songs for each user.
    @Test
    public void testAddSongAndGetRecentlyPlayedSongs() {
        store.addSong("user1", "song1");
        store.addSong("user1", "song2");
        store.addSong("user2", "song3");
        store.addSong("user2", "song4");
        store.addSong("user2", "song5");

        List<String> user1Songs = store.getRecentlyPlayedSongs("user1");
        List<String> user2Songs = store.getRecentlyPlayedSongs("user2");
        List<String> user3Songs = store.getRecentlyPlayedSongs("user3");

        Assert.assertEquals(user1Songs, Arrays.asList("song2", "song1"));
        Assert.assertEquals(user2Songs, Arrays.asList("song5", "song4", "song3"));
        Assert.assertEquals(user3Songs.size(), 0);
    }

    // This test method adds more songs than the capacity allows for a single user and checks that the least recently played songs are removed to accommodate the new ones.
    @Test
    public void testAddSongWithCapacityReached() {
        store.addSong("user1", "song1");
        store.addSong("user1", "song2");
        store.addSong("user1", "song3");
        store.addSong("user1", "song4");

        List<String> user1Songs = store.getRecentlyPlayedSongs("user1");

        Assert.assertEquals(user1Songs, Arrays.asList("song4", "song3", "song2"));
    }

    // This test method verifies that calling getRecentlyPlayedSongs with a non-existent user returns an empty list.
    @Test
    public void testGetRecentlyPlayedSongsForNonExistentUser() {
        List<String> userSongs = store.getRecentlyPlayedSongs("user1");

        Assert.assertEquals(userSongs.size(), 0);
    }
}
