package br.eti.esabreu.devjr.service;

import java.util.List;

import br.eti.esabreu.devjr.model.Telefone;

public interface TelefoneService {

	public Telefone salvar(Telefone telefone);
	
	public Telefone buscar(Long id);
	
	public List<Telefone> buscarTodos();
	
	public Telefone atualizar(Telefone telefone);
	
	public void remover(Long id);
}
