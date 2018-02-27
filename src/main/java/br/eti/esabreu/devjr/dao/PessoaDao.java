package br.eti.esabreu.devjr.dao;

import java.util.List;

import br.eti.esabreu.devjr.model.Pessoa;
import br.eti.esabreu.devjr.util.PessoaQueryParam;

public interface PessoaDao {

	public Pessoa salvar(Pessoa pessoa);
	
	public Pessoa buscar(Long id);
	
	public List<Pessoa> buscarTodas(PessoaQueryParam pessoaQueryParam);
	
	public Pessoa atualizar(Pessoa pessoa);
	
	public void remover(Pessoa pessoa);
}
