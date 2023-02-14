package com.mateus.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.aluguel.entity.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

}
