In this implementation, the RecentlyPlayedStore class has a constructor that takes a capacity parameter, specifying the maximum number of songs to store per user. The store field is a Map object that stores the user-song pairs.

The addSong() method adds a recently played song for a specific user. If the user does not exist in the store, a new entry is created with a LinkedList to store the songs. The new song is added to the front of the user's song list using addFirst(). If the number of songs exceeds the capacity, the least recently played song is removed from the end of the list using removeLast().

The getRecentlyPlayedSongs() method returns a list of recently played songs for a given user. If the user exists in the store, a new ArrayList is created from the user's song list and returned. Otherwise, an empty ArrayList is returned.

In the main method, an instance of RecentlyPlayedStore is created with a capacity of 3 songs per user. Recently played songs are added for different users using addSong, and the recently played songs for specific users are retrieved using getRecentlyPlayedSongs. The results are then printed to the console.
