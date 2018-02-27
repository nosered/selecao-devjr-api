package br.eti.esabreu.devjr.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.eti.esabreu.devjr.dao.PessoaDao;
import br.eti.esabreu.devjr.model.Pessoa;
import br.eti.esabreu.devjr.util.PessoaQueryParam;

@Repository
@Transactional
public class PessoaDaoHibernateImpl implements PessoaDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Pessoa salvar(Pessoa pessoa) {
		Long id = (Long) sessionFactory.getCurrentSession().save(pessoa);
		return buscar(id);
	}
	
	public Pessoa buscar(Long id) {
		return sessionFactory.getCurrentSession().get(Pessoa.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> buscarTodas(PessoaQueryParam pessoaQueryParam) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pessoa.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if(pessoaQueryParam.getNome() != null)
			criteria.add(Restrictions.ilike("nome", "%" + pessoaQueryParam.getNome() + "%"));
		if(pessoaQueryParam.getCpf() != null)
			criteria.add(Restrictions.ilike("cpf", "%" + pessoaQueryParam.getCpf() + "%"));
		
		return criteria.list();
	}
	
	public Pessoa atualizar(Pessoa pessoa) {
		return (Pessoa) sessionFactory.getCurrentSession().merge(pessoa);
	}
	
	public void remover(Pessoa pessoa) {
		sessionFactory.getCurrentSession().delete(pessoa);
	}
}
