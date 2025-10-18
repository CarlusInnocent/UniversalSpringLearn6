package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();

        logger.info(
                "Method: " + methodName +
                "  args: " + Arrays.toString(args) +
                " Will execute");

        Object returnedMethod = joinPoint.proceed();

        logger.info("Method executed successfully and returned: " + returnedMethod);

        return returnedMethod;
    }
}
