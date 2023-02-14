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

import com.mateus.aluguel.entity.Funcionario;
import com.mateus.aluguel.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/")
	@CrossOrigin("http://localhost:3000")
	public List<Funcionario> buscarTodos(){
		return funcionarioService.buscarTodos();
	}
	
	@PostMapping("/")
	@CrossOrigin("http://localhost:3000")
	public Funcionario inserir(@RequestBody Funcionario funcionario) {
		return funcionarioService.inserir(funcionario);
	}
	
	@PutMapping("/")
	@CrossOrigin("http://localhost:3000")
	public Funcionario alterar(@RequestBody Funcionario funcionario) {
		return funcionarioService.alterar(funcionario);
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin("http://localhost:3000")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		try {
			funcionarioService.excluir(id);
			return ResponseEntity.ok().build();
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
