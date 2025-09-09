package study.aop_prac;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // 런타임까지 살아있어야 AOP가 활용 가능함
public @interface LogExecutionTime {
}
