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

import br.eti.esabreu.devjr.model.Telefone;
import br.eti.esabreu.devjr.service.TelefoneService;

@CrossOrigin
@RestController
@RequestMapping("/telefones")
public class TelefoneController {

	@Autowired
	private TelefoneService telefoneService;
	
	@PostMapping
	public ResponseEntity<Telefone> criar(@RequestBody Telefone telefone) {
		Telefone telefoneSalvo = telefoneService.salvar(telefone);
		URI url = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/{id}")
				.buildAndExpand(telefoneSalvo.getId())
				.toUri();
		
		return ResponseEntity.created(url).body(telefoneSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Telefone> recuperar(@PathVariable("id") Long id) {
		Telefone telefone = telefoneService.buscar(id);
		return ResponseEntity.ok().body(telefone);
	}
	
	@GetMapping
	public ResponseEntity<List<Telefone>> recuperarTodos() {
		List<Telefone> telefones = telefoneService.buscarTodos();
		return ResponseEntity.ok().body(telefones);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Telefone> atualizar(@PathVariable("id") Long id, @RequestBody Telefone telefone) {
		telefone.setId(id);
		telefone = telefoneService.atualizar(telefone);
		return ResponseEntity.ok().body(telefone);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable("id") Long id) {
		telefoneService.remover(id);
		return ResponseEntity.noContent().build();
	}
}
