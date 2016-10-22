package pl.agh.id.tripsettlement.config;

import java.util.Properties;

/**
 * Abstrakcyjna klasa bazowa reprezentująca zarządzanie konfiguracją aplikacji
 */
public abstract class AbstractConfiguration {

    protected String path;
    protected Properties properties;

    /**
     * Metoda abstrakcyjna, powinna zwracać wartość przekazanego parametru konfiguracyjnego
     *
     * @param key parametr konfiguracyjny
     * @return wartość parametru konfiguracyjnego
     * @throws ConfigurationException w przypadku, gdy nie istnieje wartość dla przekazanego parametru konfiguracyjnego
     */
    public abstract String getProperty(String key) throws ConfigurationException;

    /**
     * Abstrakcyjna metoda inicjalizacyjna, powinna zajmować się odczytem konfiguracji aplikacji z pliku
     */
    public abstract void init();

    /**
     * Zwraca ściężkę do pliku konfiguracyjnego
     *
     * @return ściężka do pliku konfiguracyjnego
     */
    public String getPath() {
        return path;
    }

}
