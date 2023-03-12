package annotation.processor;

import annotation.PermissionValidation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class PermissionCheck {


    @Around("@annotation(annotation.PermissionValidation)")
    public Object checkPermission(ProceedingJoinPoint joinPoint) throws Throwable {
        var methodSignature = (MethodSignature) joinPoint.getSignature();
        var annotation = methodSignature.getMethod().getAnnotation(PermissionValidation.class);
        var name = annotation.name();
        var value = annotation.permissions();
        Object result = joinPoint.proceed();
        ((Map<String,Object>)result).put(name,value);
        return result;
    }
}
