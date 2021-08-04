package me.xtrm.delta.api.plugin;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Permission {

    HTTP_REQUESTS("HTTP Requests"),
    REMOTE_NETWORK("Websocket"),
    FILESYSTEM("Filesystem"),
    NSFW("NSFW");

    private final String permissionName;

}
