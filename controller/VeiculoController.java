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

import com.mateus.aluguel.entity.Veiculo;
import com.mateus.aluguel.service.VeiculoService;

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping("/")
	@CrossOrigin("http://localhost:3000")
	public List<Veiculo> buscarTodos(){
		return veiculoService.buscarTodos();
	}
	
	@PostMapping("/")
	@CrossOrigin("http://localhost:3000")
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		return veiculoService.inserir(veiculo);
	}
	
	@PutMapping("/")
	@CrossOrigin("http://localhost:3000")
	public Veiculo alterar(@RequestBody Veiculo veiculo) {
		return veiculoService.alterar(veiculo);
	}
	
	@PostMapping("/tornardisponivel/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> tornarDisponivel(@PathVariable("id") Long id) {
		veiculoService.tornarDisponível(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/tornarindisponivel/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> tornarIndisponivel(@PathVariable("id") Long id) {
		veiculoService.tornarIndisponível(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		try {
			veiculoService.excluir(id);
			return ResponseEntity.ok().build();
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
