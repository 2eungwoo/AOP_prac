package study.aop_prac;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PerformanceAspect {

    @Pointcut("@annotation(study.aop_prac.LogExecutionTime)")
    private void logExecutionTimePointcut() {}

    @Around("logExecutionTimePointcut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // joinPoint.proceed()가 실제 Target 메소드를 실행시키는  부분
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        String methodName = joinPoint.getSignature().getName();
        log.info("[ExecutionTime] Method: {} executed in {} ms", methodName, executionTime);

        return result;
    }
}
