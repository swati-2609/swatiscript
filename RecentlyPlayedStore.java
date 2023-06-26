import java.util.*;

public class RecentlyPlayedStore {
    private int capacity;
    private Map<String, Deque<String>> store;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>();
    }

    public void addSong(String user, String song) {
        if (!store.containsKey(user)) {
            store.put(user, new LinkedList<>());
        }

        Deque<String> userSongs = store.get(user);
        userSongs.addFirst(song);

        if (userSongs.size() > capacity) {
            userSongs.removeLast();
        }
    }

    public List<String> getRecentlyPlayedSongs(String user) {
        if (store.containsKey(user)) {
            return new ArrayList<>(store.get(user));
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);

        store.addSong("user1", "song1");
        store.addSong("user1", "song2");
        store.addSong("user2", "song3");
        store.addSong("user2", "song4");
        store.addSong("user2", "song5");

        System.out.println(store.getRecentlyPlayedSongs("user1")); 
        System.out.println(store.getRecentlyPlayedSongs("user2")); 
        System.out.println(store.getRecentlyPlayedSongs("user3"));
    }
}
