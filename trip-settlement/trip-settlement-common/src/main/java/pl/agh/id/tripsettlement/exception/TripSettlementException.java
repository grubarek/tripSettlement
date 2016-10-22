package pl.agh.id.tripsettlement.exception;

public class TripSettlementException extends Exception {

    public Type type;

    /**
     * Tworzy nowy, pusty obiekt
     */
    public TripSettlementException() {
    }

    /**
     * Tworzy nowy obiekt wyjątku, jako powód wystąpienia ustawiając wartość przekazaną w parametrze
     *
     * @param cause powód wystąpienia wyjątku
     */
    public TripSettlementException(Throwable cause) {
        super(cause);
    }

    /**
     * Tworzy nowy obiekt wyjątku, ustawiając typ na przekazany w parametrze
     *
     * @param type typ wyjątku
     */
    public TripSettlementException(Type type) {
        this.type = type;
    }

    /**
     * Tworzy nowy obiekt wyjątku, ustawiając wiadomość oraz typ na odpowiednie wartość, przekazane w parametrach
     *
     * @param message wiadomość
     * @param type    typ wyjątku
     */
    public TripSettlementException(String message, Type type) {
        super(message);
        this.type = type;
    }

    /**
     * Tworzy nowy obiekt wyjątku ustawiając wiadomość, powód wystąpienia i typ na odpowiednie wartości, przekazane w parametrach
     *
     * @param message wiadomość
     * @param cause   powód wystąpienia
     * @param type    typ wyjątku
     */
    public TripSettlementException(String message, Throwable cause, Type type) {
        super(message, cause);
        this.type = type;
    }

    /**
     * Tworzy nowy obiekt wyjątku ustawiając powód wystąpienia oraz typ na odpowiednie wartość, przekazane w parametrach
     *
     * @param cause powód wystąpienia wyjątku
     * @param type  typ wyjątku
     */
    public TripSettlementException(Throwable cause, Type type) {
        super(cause);
        this.type = type;
    }

    /**
     * Zwraca typ wyjatku
     *
     * @return typ wyjatku
     */
    public Type getStatus() {
        return type;
    }

    /**
     * Klasa wewnętrzna reprezentująca typ wyjątku
     */
    public enum Type {
        NO_CONFIGURATION_EXCEPTION,
        DB_ERROR,
        VALIDATION_ERROR,
        NO_RESULT,
        ERROR,
        DISABLE,
        NO_PERMISSION,
        UNAUTHORIZED,
    }
}
