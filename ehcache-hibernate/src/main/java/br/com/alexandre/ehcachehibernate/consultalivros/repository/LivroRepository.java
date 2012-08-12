package br.com.alexandre.ehcachehibernate.consultalivros.repository;

import java.util.List;

import br.com.alexandre.ehcachehibernate.consultalivros.domain.*;

public interface LivroRepository {
	List<Livro> findAll();
}
