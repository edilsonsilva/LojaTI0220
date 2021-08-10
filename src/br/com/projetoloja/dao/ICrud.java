package br.com.projetoloja.dao;

import java.util.List;

public interface ICrud<T> {
	String cadastro(T objeto);
	List<T> listar();
	List<T> pesquisar(T objeto);
	String atualizar(T objeto);
	String apagar(int id);	
}
