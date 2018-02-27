package br.eti.esabreu.devjr.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.eti.esabreu.devjr.model.Pessoa;
import br.eti.esabreu.devjr.service.PessoaService;
import br.eti.esabreu.devjr.util.PessoaQueryParam;

@CrossOrigin
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.salvar(pessoa);
		URI url = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/{id}")
				.buildAndExpand(pessoaSalva.getId())
				.toUri();
		return ResponseEntity.created(url).body(pessoaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> recuperar(@PathVariable("id") Long id) {
		Pessoa pessoa = pessoaService.buscar(id);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> recuperarTodas(PessoaQueryParam pessoaQueryParam) {
		List<Pessoa> pessoas = pessoaService.buscarTodas(pessoaQueryParam);
		return ResponseEntity.ok().body(pessoas);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) {
		pessoa.setId(id);
		pessoa = pessoaService.atualizar(pessoa);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable("id") Long id) {
		pessoaService.remover(id);
		return ResponseEntity.noContent().build();
	}
	
}
