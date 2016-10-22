package pl.agh.id.tripsettlement.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.agh.id.tripsettlement.exception.TripSettlementException;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Klasa implementująca interfejs {@code AbstractConfiguration}, odpowiedzialna za odczyt i przechowywanie pliku konfiguracyjnego aplikacji.
 * Pozwala uzyskać dostęp do poszczególnych wpisów konfiguracyjnych.
 */
@Singleton
@Startup
public class TripSettlementConfiguration extends AbstractConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(TripSettlementConfiguration.class);

    @PostConstruct
    @Override
    public void init() {
        String configDir = System.getenv(Configuration.TRIP_SETTLEMENT_ENVIRONMENT_VARIABLE);
        this.path = configDir + File.separator + TripSettlementConfigurationProperty.TRIP_SETTLEMENT_CONFIG_FILE_NAME;

        try {
            properties = loadConfiguration();

            logger.info("Configuration properties:");
            Enumeration em = properties.keys();
            while (em.hasMoreElements()) {
                String str = (String) em.nextElement();
                logger.info(str + ": " + properties.get(str));
            }
        } catch (Exception e) {
            throw new RuntimeException("TripSettlementConfiguration.Exception", e);
        }
    }

    private Properties loadConfiguration() throws IOException {
        Properties properties = new Properties();
        File propFile = new File(path);
        logger.info("Configuration file: " + propFile.getAbsolutePath());

        InputStream is = null;

        try {
            is = new FileInputStream(propFile);
            properties.load(is);
        } catch (IOException e) {
            throw e;
        } finally {
            if (is != null) {
                is.close();
            }
        }

        return properties;
    }

    /**
     * Zwraca wartość przekazanego parametru konfiguracyjnego
     *
     * @param key parametr konfiguracyjny
     * @return wartość parametru konfiguracyjnego
     * @throws ConfigurationException w przypadku, gdy nie istnieje wartość dla przekazanego parametru konfiguracyjnego
     */
    @Override
    public String getProperty(String key) throws ConfigurationException {
        if (properties == null) {
            throw new ConfigurationException(TripSettlementException.Type.NO_CONFIGURATION_EXCEPTION);
        }

        return properties.getProperty(key);
    }

    public String getPropertySafely(String key) throws RuntimeException {
        if (properties == null) {
            throw new RuntimeException();
        }

        return properties.getProperty(key);
    }
}
