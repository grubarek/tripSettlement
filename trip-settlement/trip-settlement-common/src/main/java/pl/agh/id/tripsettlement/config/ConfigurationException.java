package pl.agh.id.tripsettlement.config;

import pl.agh.id.tripsettlement.exception.TripSettlementException;

/**
 * Wyjątek reprezentujący problemy związane z konfiguracją aplikacji
 */
public class ConfigurationException extends TripSettlementException {

    /**
     * Tworzy nowy wyjątek wykorzystując obiekt typu
     *
     * @param type typ wyjątku
     */
    public ConfigurationException(Type type) {
        super(type);
    }
}
