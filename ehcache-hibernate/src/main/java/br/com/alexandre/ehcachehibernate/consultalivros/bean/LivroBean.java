package br.com.alexandre.ehcachehibernate.consultalivros.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.alexandre.ehcachehibernate.consultalivros.domain.Livro;
import br.com.alexandre.ehcachehibernate.consultalivros.repository.LivroRepository;

@ManagedBean
@SessionScoped
public class LivroBean implements Serializable {

	private static final long serialVersionUID = -1270136534025681723L;

	// Atributos
	
	private List<Livro> livros;

	@ManagedProperty(value="#{livroRepository}")
	private LivroRepository livroRepository;
	
	// Construtor
	
	public LivroBean() {		
	}
	
	// Action
	
	public String listar() {
		this.livros = livroRepository.findAll();
		return "lista";
	}

	// Getters e setters
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivroRepository(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

}
