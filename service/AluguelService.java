package com.mateus.aluguel.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.aluguel.entity.Aluguel;
import com.mateus.aluguel.repository.AluguelRepository;


@Service
public class AluguelService {
	
	@Autowired
	private AluguelRepository aluguelRepository;
	
	
	
	public List<Aluguel> buscarTodos(){
		return aluguelRepository.findAll();
	}
	
	public Aluguel inserir(Aluguel aluguel) {
		aluguel.setDataCadastro(new Date());
		return aluguelRepository.saveAndFlush(aluguel);
	}
	
	public Aluguel alterar(Aluguel aluguel) {
		aluguel.setDataCadastro(new Date());
		return aluguelRepository.saveAndFlush(aluguel);
	}
	
	public void excluir(Long id) {
		try {
			Aluguel cliente = aluguelRepository.findById(id).get();
			aluguelRepository.delete(cliente);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro");
		}
	}

}
