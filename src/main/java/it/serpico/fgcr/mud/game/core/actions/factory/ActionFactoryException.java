package it.serpico.fgcr.mud.game.core.actions.factory;

public class ActionFactoryException extends RuntimeException {
    public ActionFactoryException() {
        super();
    }

    public ActionFactoryException(String message) {
        super(message);
    }

    public ActionFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActionFactoryException(Throwable cause) {
        super(cause);
    }

    protected ActionFactoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
