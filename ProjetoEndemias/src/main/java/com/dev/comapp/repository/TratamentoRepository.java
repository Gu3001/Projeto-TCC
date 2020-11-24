package com.dev.comapp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.comapp.models.Amostra;
import com.dev.comapp.models.Enderecos;
import com.dev.comapp.models.Tratamento;

public interface TratamentoRepository extends JpaRepository<Tratamento, Long>{

		@Query("select e from Tratamento e where e.enderecos.id = ?1")
		List<Tratamento>buscarPorIdEnderecos(long id);
	
}