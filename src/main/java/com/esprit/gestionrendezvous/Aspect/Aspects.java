package com.esprit.gestionrendezvous.Aspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class Aspects {

   

    @After("execution(* com.esprit.gestionrendezvous.services.*.add*(..))")
    public void logAfterAdd(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("logAfterAdd  " + name );
    }

   


}
