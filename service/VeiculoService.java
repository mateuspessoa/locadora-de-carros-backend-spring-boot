package com.mateus.aluguel.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.aluguel.entity.Veiculo;
import com.mateus.aluguel.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public List<Veiculo> buscarTodos(){
		return veiculoRepository.findAll();
	}
	
	public Veiculo inserir(Veiculo veiculo) {
		veiculo.setDataCadastro(new Date());
		veiculo.setStatus("disponível");
		return veiculoRepository.saveAndFlush(veiculo);
	}
	
	public Veiculo alterar(Veiculo veiculo) {
		veiculo.setDataCadastro(new Date());
		veiculo.setStatus("disponível");
		return veiculoRepository.saveAndFlush(veiculo);
	}
	
	public void excluir(Long id) {
		try {
			Veiculo veiculo = veiculoRepository.findById(id).get();
			veiculoRepository.delete(veiculo);
		} catch (Exception e) {
			throw new RuntimeException("Existem aluguéis com esse veículo");
		}
	}

}
