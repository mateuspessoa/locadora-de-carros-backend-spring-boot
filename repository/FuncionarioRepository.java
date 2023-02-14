package com.mateus.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mateus.aluguel.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
