package io.yorkecao.springbootdemo.advice;

import io.yorkecao.springbootdemo.annotation.DemoAction;
import io.yorkecao.springbootdemo.constants.DemoConstant;
import io.yorkecao.springbootdemo.constants.ExceptionType;
import io.yorkecao.springbootdemo.domain.model.DemoLog;
import io.yorkecao.springbootdemo.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Yorke
 */
@Aspect
@Slf4j
@Component
public class DemoLogAspect {

    @Pointcut("execution(* io.yorkecao.springbootdemo.web.*.*(..)) && @annotation(io.yorkecao.springbootdemo.annotation.DemoAction)")
    public void controllerAction(){}

    @Around("controllerAction()")
    public Result controllerRecordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        DemoLog demoLog = new DemoLog();

        // 获取IP
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        demoLog.setIp(request.getRemoteAddr());

        // 获取当前时间
        demoLog.setTime(new Date());

        // 获取方法名
        demoLog.setMethodName(joinPoint.getSignature().getName());

        Stream.of(Class.forName(joinPoint.getTarget().getClass().getName()).getMethods())
                .filter(method -> method.getName().equals(joinPoint.getSignature().getName()))
                .filter(method -> method.getParameterTypes().length == joinPoint.getArgs().length)
                .findAny()
                // 从方法注解中获取描述信息
                .ifPresent(method -> {
                    Optional.ofNullable(method.getAnnotation(DemoAction.class))
                            .ifPresent(action -> demoLog.setDescription(String.valueOf(action.actionType()) + action.value()));
                    Optional.ofNullable(method.getAnnotation(RequestMapping.class))
                            .ifPresent(mapping -> demoLog.setInterfaceName(String.join(", ", mapping.value())));
                });

        demoLog.setParams(joinPoint.getArgs());

        // 获取执行结果
        Result result = (Result) joinPoint.proceed();
        demoLog.setResult(result);
        demoLog.setType(ExceptionType.SUCCESS.getCode().equals(result.getCode())
                ? DemoConstant.ACTION_RUSULT_SUCCESS
                : DemoConstant.ACTION_RESULT_FAILURE);

        log.info(demoLog.toString());

        return result;
    }

    @AfterThrowing(pointcut = "controllerAction()", throwing = "e")
    public void controllerExceptionLog(JoinPoint joinPoint, Throwable e) throws ClassNotFoundException {
        DemoLog demoLog = new DemoLog();

        // 获取IP
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        demoLog.setIp(request.getRemoteAddr());

        // 获取当前时间
        demoLog.setTime(new Date());

        // 获取方法名
        demoLog.setMethodName(joinPoint.getSignature().getName());

        Stream.of(Class.forName(joinPoint.getTarget().getClass().getName()).getMethods())
                .filter(method -> method.getName().equals(joinPoint.getSignature().getName()))
                .filter(method -> method.getParameterTypes().length == joinPoint.getArgs().length)
                .findAny()
                // 从方法注解中获取描述信息
                .ifPresent(method -> {
                    Optional.ofNullable(method.getAnnotation(DemoAction.class))
                            .ifPresent(action -> demoLog.setDescription(String.valueOf(action.actionType()) + action.value()));
                    Optional.ofNullable(method.getAnnotation(RequestMapping.class))
                            .ifPresent(mapping -> demoLog.setInterfaceName(String.join(", ", mapping.value())));
                });

        demoLog.setParams(joinPoint.getArgs());

        // 获取执行结果
        demoLog.setType(DemoConstant.ACTION_RESULT_FAILURE);
        demoLog.setResult(e);

        log.info(demoLog.toString());
    }
}
