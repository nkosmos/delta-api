package me.xtrm.delta.api.client.friend;

import java.util.List;

public interface FriendManager {

    List<FriendData> getFriends();

    boolean isFriend(String playerName);

    void addFriend(String playerName);

    void removeFriend(String playerName);

}
