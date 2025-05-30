package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspects {

    public Logger logger = Logger.getLogger(LoggingAspects.class.getName());

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{

        String methodName = joinPoint.getSignature().getName();

        Object [] arguments = joinPoint.getArgs();

        logger.info("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute");

        Object returnedByMethod = joinPoint.proceed();

        logger.info("Method executed and returned " + returnedByMethod);

        return returnedByMethod;

    }

}
