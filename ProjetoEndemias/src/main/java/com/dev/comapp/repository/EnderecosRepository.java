package com.dev.comapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dev.comapp.models.Enderecos;


public interface EnderecosRepository extends JpaRepository<Enderecos, Long>{
	
	@Query("select e from Enderecos e where e.ficha.id = ?1")
	List<Enderecos>buscarPorIdFicha(long id);
}