package br.eti.esabreu.devjr.dao;

import java.util.List;

import br.eti.esabreu.devjr.model.Telefone;

public interface TelefoneDao {

	public Telefone salvar(Telefone telefone);
	
	public Telefone buscar(Long id);
	
	public List<Telefone> buscarTodos();
	
	public Telefone atualizar(Telefone telefone);
	
	public void remover(Telefone telefone);
}
