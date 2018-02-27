package br.eti.esabreu.devjr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.devjr.dao.TelefoneDao;
import br.eti.esabreu.devjr.model.Telefone;
import br.eti.esabreu.devjr.service.TelefoneService;

@Service
public class TelefoneServiceImpl implements TelefoneService {

	@Autowired
	private TelefoneDao telefoneDao;
	
	public Telefone salvar(Telefone telefone) {
		return telefoneDao.salvar(telefone);
	}
	
	public Telefone buscar(Long id) {
		return telefoneDao.buscar(id);
	}
	
	public List<Telefone> buscarTodos() {
		return telefoneDao.buscarTodos();
	}
	
	public Telefone atualizar(Telefone telefone) {
		return telefoneDao.atualizar(telefone);
	}
	
	public void remover(Long id) {
		Telefone telefone = telefoneDao.buscar(id);
		telefoneDao.remover(telefone);
	}
}
