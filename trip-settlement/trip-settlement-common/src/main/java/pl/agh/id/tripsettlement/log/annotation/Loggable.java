package pl.agh.id.tripsettlement.log.annotation;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * Customowa adnotacja stworzona na potrzeby logowania wywolan metod.
 * Posiada parametry:
 * - withParams - jesli zostanie ustawiona na {@code true} logger wypisze rowniez parametry z jakimi zostala wywolana
 * metoda oznaczona adnotacja
 */
@InterceptorBinding
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Loggable {
    @Nonbinding boolean withParams() default true;
}
