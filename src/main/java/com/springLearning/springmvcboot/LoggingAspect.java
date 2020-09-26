package com.springLearning.springmvcboot;



import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;





@Aspect
@Component
public class LoggingAspect {

	
	private static final Logger LOGGER = 	LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.springLearning.springmvcboot.AlienController.getAliens())")
	public void logBefore() {
		
		LOGGER.info("getAliens() Before Called from Aspect class");
		LOGGER.info("This is executed beofre the method");
	}
	

	@After("execution(public * com.springLearning.springmvcboot.AlienController.getAliens())")
	public void logAfter() {
		
		LOGGER.info("getAliens() After Called from Aspect class");
		LOGGER.info("This works as finally irrespective of error this will be called");
	}
	
	

	@AfterReturning("execution(public * com.springLearning.springmvcboot.AlienController.getAliens())")
	public void logAfterreturn() {
		
		LOGGER.info("getAliens() After Called from Aspect class");
		
		LOGGER.info("This will be called only if there is no issues and no errors and method is called properly");
	}
	
	

	@AfterThrowing("execution(public * com.springLearning.springmvcboot.AlienController.getAliens())")
	public void logAfterthrowing() {
		
		LOGGER.info("getAliens() After Called from Aspect class");
		LOGGER.info("This is will be called only when the method throws some exception used to identify issues.");
	}
}
