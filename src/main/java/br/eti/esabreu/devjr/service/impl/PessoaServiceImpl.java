package br.eti.esabreu.devjr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.devjr.dao.PessoaDao;
import br.eti.esabreu.devjr.model.Pessoa;
import br.eti.esabreu.devjr.service.PessoaService;
import br.eti.esabreu.devjr.util.PessoaQueryParam;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaDao pessoaDao;
	
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaDao.salvar(pessoa);
	}
	
	public Pessoa buscar(Long id) {
		return pessoaDao.buscar(id);
	}
	
	public List<Pessoa> buscarTodas(PessoaQueryParam pessoaQueryParam) {
		return pessoaDao.buscarTodas(pessoaQueryParam);
	}
	
	public Pessoa atualizar(Pessoa pessoa) {
		return pessoaDao.atualizar(pessoa);
	}
	
	public void remover(Long id) {
		Pessoa pessoa = pessoaDao.buscar(id);
		pessoaDao.remover(pessoa);
	}
}
