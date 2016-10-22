package pl.agh.id.tripsettlement.rest.response;

import java.io.Serializable;

public class MessageApplicationResponse implements Serializable {

    private static final long serialVersionUID = 4281117731396170589L;

    private String message;

    public MessageApplicationResponse() {
    }

    public MessageApplicationResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageApplicationResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
