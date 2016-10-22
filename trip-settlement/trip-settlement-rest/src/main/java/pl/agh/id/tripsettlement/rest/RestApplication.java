package pl.agh.id.tripsettlement.rest;

import pl.agh.id.tripsettlement.rest.resource.*;
import pl.agh.id.tripsettlement.rest.provider.ExceptionProvider;
import pl.agh.id.tripsettlement.rest.provider.ObjectMapperContextResolver;
import pl.agh.id.tripsettlement.rest.provider.TripSettlementExceptionProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Klasa dziedziczaca po klasie {@code Application}, do konfiguracji środowiska aplikacji dostępnej na podanym urlu
 */
@ApplicationPath("/")
public class RestApplication extends Application {

    /**
     * Metoda zwracająca zbiór klas zasobów. Rejestrowane są w niej klasy zasobów.
     *
     * @return zbiór klas
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        addRestResourceClasses(resources);
        addProviders(resources);

        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(UserResource.class);

    }

    private void addProviders(Set<Class<?>> resources) {
        resources.add(ObjectMapperContextResolver.class);
        resources.add(TripSettlementExceptionProvider.class);
        resources.add(ExceptionProvider.class);
    }
}
