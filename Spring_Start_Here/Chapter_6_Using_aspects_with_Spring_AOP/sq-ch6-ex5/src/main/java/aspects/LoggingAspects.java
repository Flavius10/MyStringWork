package aspects;

import models.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspects {

    private final Logger logger = Logger.getLogger(LoggingAspects.class.getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{

        logger.info("Logging Aspect: Calling the intercepted method");

        Object returnedValue = joinPoint.proceed();

        logger.info("Logging Aspect: Method executed and returned " +
                returnedValue);

        return returnedValue;
    }

}
