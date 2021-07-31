package me.xtrm.delta.api.exception;

public class InvalidDelegationException extends RuntimeException {

    public InvalidDelegationException() {
        super();
    }

    public InvalidDelegationException(String message) {
        super(message);
    }

    public InvalidDelegationException(Throwable cause) {
        super(cause);
    }

    public InvalidDelegationException(String message, Throwable cause) {
        super(message, cause);
    }

}
