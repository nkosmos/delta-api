package me.xtrm.delta.client.api.plugin.exception;

public class InvalidManifestException extends RuntimeException {

    public InvalidManifestException(){ super(); }
    public InvalidManifestException(String message){ super(message); }
    public InvalidManifestException(Throwable cause){ super(cause); }
    public InvalidManifestException(String message, Throwable cause){ super(message, cause); }

}
