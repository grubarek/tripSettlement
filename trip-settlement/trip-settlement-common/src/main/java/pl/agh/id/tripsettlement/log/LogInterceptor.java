package pl.agh.id.tripsettlement.log;

import pl.agh.id.tripsettlement.log.annotation.Loggable;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

/**
 * Klasa odpowiadajaca za przechwytywanie zdarzen zwiazanych z wywolaniem metod oznaczonych adnotacja @Loggable.
 */
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 100)
@Loggable
public class LogInterceptor {

    private static final Logger logger = Logger.getLogger("tripsettlementLogger");

    /**
     * Operacja wywolywana podczas wywolania operacja oznaczonej adnotacja @Loggable. Loguje ona z wykorzystaniem klasy Logger
     * wywolania metod. Logowanie moze odbywac sie z parametrami wywolania metody lub bez.
     *
     * @param ctx kontekst wywolania metody
     * @return object
     * @throws Exception jesli wystapi blad podczas wykonywania operacji
     */
    @AroundInvoke
    public Object logInvocation(InvocationContext ctx) throws Exception {
        boolean withParams = false;
        String logMessage;

        String className = ctx.getMethod().getDeclaringClass().getSimpleName();
        String methodName = ctx.getMethod().getName();

        logMessage = String.format("[%s.%s] invoked", className, methodName);

        Object[] parameters = ctx.getParameters();
        StringBuilder paramsBuilder = new StringBuilder();

        Loggable annotation = ctx.getMethod().getAnnotation(Loggable.class);
        if (annotation == null) {
            annotation = ctx.getTarget().getClass().getAnnotation(Loggable.class);
            if (annotation != null) {
                withParams = annotation.withParams();
            } else {
                withParams = false;
            }
        }
        if (parameters != null && withParams == true) {
            for (Object parameter : parameters) {
                if (parameter != null) {
                    if (paramsBuilder.length() > 0) {
                        paramsBuilder.append(", ");
                    }
                    paramsBuilder.append(parameter.toString());
                }
            }
            logMessage = logMessage.concat(" with params: ").concat(paramsBuilder.toString());
        }


        logger.info(logMessage);
        return ctx.proceed();
    }

}
