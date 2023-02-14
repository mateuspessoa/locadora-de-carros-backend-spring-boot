package com.mateus.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.aluguel.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
