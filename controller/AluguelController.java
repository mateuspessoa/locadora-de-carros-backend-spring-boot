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

import com.mateus.aluguel.entity.Aluguel;
import com.mateus.aluguel.service.AluguelService;

@RestController
@RequestMapping("/api/aluguel")
public class AluguelController {
	
	@Autowired
	private AluguelService aluguelService;
	
	@GetMapping("/")
	@CrossOrigin("http://localhost:3000")
	public List<Aluguel> buscarTodos(){
		return aluguelService.buscarTodos();
	}
	
	@PostMapping("/")
	@CrossOrigin("http://localhost:3000")
	public Aluguel inserir(@RequestBody Aluguel aluguel) {
		return aluguelService.inserir(aluguel);
	}
	
	@PutMapping("/")
	@CrossOrigin("http://localhost:3000")
	public Aluguel alterar(@RequestBody Aluguel aluguel) {
		return aluguelService.alterar(aluguel);
	}
	
	@PostMapping("/confirmarpagamento/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> confirmarPagamento(@PathVariable("id") Long id) {
		aluguelService.confirmarPagamento(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/confirmardevolucao/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> confirmarDevolucao(@PathVariable("id") Long id) {
		aluguelService.confirmarDevolucao(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		try {
			aluguelService.excluir(id);
			return ResponseEntity.ok().build();
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
