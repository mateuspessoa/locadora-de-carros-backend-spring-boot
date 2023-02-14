package com.mateus.aluguel.controller;

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

import com.mateus.aluguel.entity.Cliente;
import com.mateus.aluguel.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class CLienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/")
	@CrossOrigin("http://localhost:3000")
	public List<Cliente> buscarTodos(){
		return clienteService.buscarTodos();
	}
	
	@PostMapping("/")
	@CrossOrigin("http://localhost:3000")
	public Cliente inserir(@RequestBody Cliente cliente) {
		return clienteService.inserir(cliente);
	}
	
	@PutMapping("/")
	@CrossOrigin("http://localhost:3000")
	public Cliente alterar(@RequestBody Cliente cliente) {
		return clienteService.alterar(cliente);
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		try {
			clienteService.excluir(id);
			return ResponseEntity.ok().build();
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
