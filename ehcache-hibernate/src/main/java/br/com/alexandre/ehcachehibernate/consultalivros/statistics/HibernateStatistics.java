package br.com.alexandre.ehcachehibernate.consultalivros.statistics;

import java.io.Serializable;

import javax.persistence.EntityManagerFactory;

import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Component;

@Component
public class HibernateStatistics implements Serializable {

	private static final long serialVersionUID = -2749285215052344629L;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Statistics getStatistics() {
		final EntityManagerFactory nativeEntityManagerFactory = ((EntityManagerFactoryInfo) entityManagerFactory).getNativeEntityManagerFactory();
		final EntityManagerFactoryImpl entityManagerFactoryImpl = (EntityManagerFactoryImpl) nativeEntityManagerFactory;
		return entityManagerFactoryImpl.getSessionFactory().getStatistics();
	}
	
}
