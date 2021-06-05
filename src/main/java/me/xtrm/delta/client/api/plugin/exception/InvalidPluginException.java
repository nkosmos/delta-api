package me.xtrm.delta.client.api.plugin.exception;

public class InvalidPluginException extends RuntimeException {

    public InvalidPluginException(){ super(); }
    public InvalidPluginException(String message){ super(message); }
    public InvalidPluginException(Throwable cause){ super(cause); }
    public InvalidPluginException(String message, Throwable cause){ super(message, cause); }

}
