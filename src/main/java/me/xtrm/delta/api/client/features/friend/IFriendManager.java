package me.xtrm.delta.api.client.features.friend;

import me.xtrm.delta.api.client.features.file.ISavable;

import java.util.List;

public interface IFriendManager extends ISavable {

    List<FriendData> getFriends();

    boolean isFriend(String playerName);

    void addFriend(String playerName);

    void removeFriend(String playerName);

}
