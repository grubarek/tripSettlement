package pl.agh.id.tripsettlement.rest.response;

public final class ResponseMessage {

    private ResponseMessage() {
    }

    public class Authentication {
    }

    /**
     * W pierwszej wersji nie ma logowania na konto, ale dla w przyszłości poprzez strone WWW możliwe będzie
     * zapisywanie i aktualizacja danych poprzez logowanie: user-pass

     */
    public final class Account {
        private Account() {
        }

        public static final String REGISTERED = "Zgłoszenie rejestracji zostało wysłane do administratora. " +
                "Poczekaj na wiadomość email.";
        public static final String DELETED = "Konto zostało usunięte.";
        public static final String ACCEPTED = "Konto zostało zaakceptowane.";
        public static final String REJECTED = "Konto zostało odrzucone.";
        public static final String UPDATED = "Konto zostało zaktualizowane.";
    }
}
