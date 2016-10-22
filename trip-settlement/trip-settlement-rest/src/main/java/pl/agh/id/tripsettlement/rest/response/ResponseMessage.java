package pl.agh.id.tripsettlement.rest.response;

public final class ResponseMessage {

    private ResponseMessage() {
    }

    public class Authentication {
    }

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
