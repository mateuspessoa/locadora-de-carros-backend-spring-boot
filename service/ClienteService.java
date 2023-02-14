package com.mateus.aluguel.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.aluguel.entity.Cliente;
import com.mateus.aluguel.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public Cliente inserir(Cliente cliente) {
		cliente.setDataCadastro(new Date());
		return clienteRepository.saveAndFlush(cliente);
	}
	
	public Cliente alterar(Cliente cliente) {
		cliente.setDataCadastro(new Date());
		return clienteRepository.saveAndFlush(cliente);
	}
	
	public void excluir(Long id) {
		try {
			Cliente cliente = clienteRepository.findById(id).get();
			clienteRepository.delete(cliente);
		} catch (Exception e) {
			throw new RuntimeException("Existem aluguéis com esse cliente");
		}
	}

}
