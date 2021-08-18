package me.xtrm.delta.api.client.features.friend;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
public @Data class FriendData {
    private final String playerName;
    private final UUID playerUUID;
    private String nickname;
}
