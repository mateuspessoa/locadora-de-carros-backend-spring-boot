package com.mateus.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.aluguel.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
