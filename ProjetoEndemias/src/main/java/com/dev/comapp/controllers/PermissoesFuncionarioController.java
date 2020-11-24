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
import com.dev.comapp.models.Funcionario;
import com.dev.comapp.models.Papel;
import com.dev.comapp.models.PermissoesFuncionario;
import com.dev.comapp.repository.PermissoesFuncionarioRepository;
import com.dev.comapp.repository.PapelRepository;
import com.dev.comapp.repository.FuncionarioRepository;



@Controller
public class PermissoesFuncionarioController {
	
	@Autowired
	private PermissoesFuncionarioRepository repository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;
	

	
	@GetMapping("administrativo/permissoesFuncionario/permissoesFuncionarios")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/administrativo/permissoesFuncionario/permissoesFuncionarioLista");
		java.util.List<PermissoesFuncionario> listaPermissoesFuncionarios =  repository.findAll();
		mv.addObject("permissoesFuncionarios", listaPermissoesFuncionarios);
		mv.addObject("quantidadePermissoesFuncionarios", listaPermissoesFuncionarios.size());
		
		return mv;
	}
	
//	//BUSCAR ALUNO POR NOME
//	@GetMapping("/buscarPermissoesFuncionarioNome")
//	public ModelAndView buscarPermissoesFuncionarios(String nome) {		
//		ModelAndView mv = new ModelAndView("/permissoesFuncionarioLista");
//		mv.addObject("permissoesFuncionarios", repository.buscarPorNome(nome));		
//		return mv;
//	}
	
	
	
	
	
	
	@GetMapping("/administrativo/permissoesFuncionario/adicionarPermFunc")
	public ModelAndView add(PermissoesFuncionario permissoesFuncionario) {
		
		
		ModelAndView mv = new ModelAndView("/administrativo/permissoesFuncionario/permissoesFuncionarioAdicionar");
		mv.addObject("permissoesFuncionario", permissoesFuncionario);
	
		List<Funcionario> listaFuncionario = funcionarioRepository.findAll();
		mv.addObject("funcionarios",listaFuncionario);
		
		List<Papel> listaPapeis = papelRepository.findAll();
		mv.addObject("papeis", listaPapeis);
		
		return mv;
	}
	
	@GetMapping("/administrativo/permissoesFuncionario/editarPermissoesFuncionario/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<PermissoesFuncionario> permissoesFuncionario = repository.findById(id);
		PermissoesFuncionario e = permissoesFuncionario.get();	
		
		return add(e);
	}
	
	@GetMapping("/administrativo/permissoesFuncionario/removerPermissoesFuncionario/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<PermissoesFuncionario> permissoesFuncionario = repository.findById(id);
		PermissoesFuncionario e = permissoesFuncionario.get();
		repository.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/administrativo/permissoesFuncionario/salvarPermissoesFuncionario")
	public ModelAndView save(@Valid PermissoesFuncionario permissoesFuncionario, BindingResult result) {
		
//		if(result.hasErrors()  || !permissoesFuncionario.getCpf().equals(11)) {
//			return add(permissoesFuncionario);
//		}
		repository.saveAndFlush(permissoesFuncionario);
		
		return buscarTodos();
	}
	
}
