package com.dev.comapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.comapp.models.Funcionario;



public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

//	@Query("select e from funcionario e where e.nome like %?1%")
//	List<Funcionario> buscarPorNome(String nome);
}