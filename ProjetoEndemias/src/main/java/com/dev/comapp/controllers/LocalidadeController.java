package com.dev.comapp.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.dev.comapp.models.Localidade;
import com.dev.comapp.models.Cidade;

import com.dev.comapp.repository.LocalidadeRepository;
import com.dev.comapp.repository.CidadeRepository;



@Controller
public class LocalidadeController {
	
	@Autowired
	private LocalidadeRepository repository;
	
	@Autowired
	private CidadeRepository repositoryCidade;
	
	@GetMapping("administrativo/localidade/localidades")
	public ModelAndView buscarTodos() {
		ModelAndView mv = new ModelAndView("/administrativo/localidade/localidadeLista");
		mv.addObject("localidades", repository.findAll());
		return mv;
	}
	
	@GetMapping("/administrativo/localidade/adicionarLocalidade")
	public ModelAndView add(Localidade localidade) {
		ModelAndView mv = new ModelAndView("/administrativo/localidade/localidadeAdicionar");
		mv.addObject("localidade", localidade);
		List<Cidade> listaCidade = repositoryCidade.findAll();
		mv.addObject("cidades",listaCidade);
		return mv;
	}
	
	@GetMapping("/administrativo/localidade/editarLocalidade/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Localidade> localidade = repository.findById(id);
		Localidade e = localidade.get();	
		
		return add(e);
	}
	
	@GetMapping("/administrativo/localidade/removerLocalidade/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Localidade> localidade = repository.findById(id);
		Localidade e = localidade.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/administrativo/localidade/salvarLocalidade")
	public ModelAndView save(@Valid Localidade localidade, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(localidade);
		}
		
		repository.saveAndFlush(localidade);
		
		return buscarTodos();
	}
	
}
