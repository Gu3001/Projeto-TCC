package com.dev.comapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.comapp.models.Amostra;
import com.dev.comapp.models.Enderecos;

public interface AmostraRepository extends JpaRepository<Amostra, Long>{
	@Query("select e from Amostra e where e.enderecos.id = ?1")
	List<Amostra>buscarPorIdEnderecos(long id);
}