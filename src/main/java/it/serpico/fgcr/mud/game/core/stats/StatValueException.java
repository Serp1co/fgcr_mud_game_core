package it.serpico.fgcr.mud.game.core.stats;

public class StatValueException extends RuntimeException {
    public StatValueException() {
        super();
    }

    public StatValueException(String message) {
        super(message);
    }

    public StatValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public StatValueException(Throwable cause) {
        super(cause);
    }

    protected StatValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static String StatTooHighExceptionMessage(Class<Stat> clazz, Object value) {
         return clazz.getName() + " Value is too high " + value;
    }

}
