package br.com.alexandre.ehcachehibernate.consultalivros.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import br.com.alexandre.ehcachehibernate.consultalivros.domain.Livro;
import br.com.alexandre.ehcachehibernate.consultalivros.repository.LivroRepository;

@Repository("livroRepository")
public class LivroDAO implements LivroRepository, Serializable {

	private static final long serialVersionUID = -7044410948790649673L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Livro> findAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Livro> criteriaQuery = criteriaBuilder.createQuery(Livro.class);
		Root<Livro> from = criteriaQuery.from(Livro.class);
		CriteriaQuery<Livro> select = criteriaQuery.select(from);
		
		TypedQuery<Livro> typedQuery = entityManager.createQuery(select);
		typedQuery.setHint("org.hibernate.cacheable", true);
		
		return typedQuery.getResultList();	
	}

}
