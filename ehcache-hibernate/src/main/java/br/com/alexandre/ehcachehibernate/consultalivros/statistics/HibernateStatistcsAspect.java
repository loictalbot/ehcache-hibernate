package br.com.alexandre.ehcachehibernate.consultalivros.statistics;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HibernateStatistcsAspect implements Serializable {

	private static final long serialVersionUID = -7068103907942160954L;

	@Autowired
	private HibernateStatistics hibernateStatistics;
	
	private Logger logger = Logger.getLogger(HibernateStatistcsAspect.class);
	
	@After("execution(* br.com.alexandre.ehcachehibernate.consultalivros.dao.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		logger.info(hibernateStatistics.getStatistics());
	}
	
}
