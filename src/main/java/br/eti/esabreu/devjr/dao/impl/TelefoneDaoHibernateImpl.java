package br.eti.esabreu.devjr.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.eti.esabreu.devjr.dao.TelefoneDao;
import br.eti.esabreu.devjr.model.Telefone;

@Repository
@Transactional
public class TelefoneDaoHibernateImpl implements TelefoneDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Telefone salvar(Telefone telefone) {
		Long id = (Long) sessionFactory.getCurrentSession().save(telefone);
		return buscar(id);
	}
	
	public Telefone buscar(Long id) {
		return sessionFactory.getCurrentSession().get(Telefone.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Telefone> buscarTodos() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Telefone");
		return query.list();
	}
	
	public Telefone atualizar(Telefone telefone) {
		return (Telefone) sessionFactory.getCurrentSession().merge(telefone);
	}
	
	public void remover(Telefone telefone) {
		sessionFactory.getCurrentSession().delete(telefone);
	}
}
