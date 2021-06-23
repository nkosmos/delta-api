package me.xtrm.delta.api.exception;

public class InvalidModuleException extends RuntimeException {

    public InvalidModuleException() {
        super();
    }

    public InvalidModuleException(String message) {
        super(message);
    }

    public InvalidModuleException(Throwable cause) {
        super(cause);
    }

    public InvalidModuleException(String message, Throwable cause) {
        super(message, cause);
    }

}
