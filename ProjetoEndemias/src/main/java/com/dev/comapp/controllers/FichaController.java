package com.dev.comapp.controllers;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.comapp.Conexao;
import com.dev.comapp.models.Amostra;
import com.dev.comapp.models.Depositos;
import com.dev.comapp.models.Enderecos;
import com.dev.comapp.models.Ficha;
import com.dev.comapp.models.Tratamento;
import com.dev.comapp.repository.AmostraRepository;
import com.dev.comapp.repository.CidadeRepository;
import com.dev.comapp.repository.DepositosRepository;
import com.dev.comapp.repository.EnderecosRepository;
import com.dev.comapp.repository.FichaRepository;
import com.dev.comapp.repository.FuncionarioRepository;
import com.dev.comapp.repository.TratamentoRepository;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.view.JasperViewer;
import java.io.InputStream;


@Controller
public class FichaController{
	
	
	private List<Enderecos> listaEnderecos = new ArrayList<Enderecos>();
	private List<Amostra> listaAmostra = new ArrayList<Amostra>();
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private FichaRepository fichaRepository;
	@Autowired
	private EnderecosRepository enderecosRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private AmostraRepository amostraRepository;
	@Autowired
	private DepositosRepository depositosRepository;
	@Autowired
	private TratamentoRepository tratamentoRepository;
	@Autowired
	private DataSource dataSource;
	
	private String controleSalvar = "nadaConsta";
	
	@GetMapping("administrativo/ficha/fichas")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("/administrativo/ficha/fichaLista");
		mv.addObject("fichas", fichaRepository.findAll()); //itensEntrada enderecos
		
		return mv;
	}
	
	
//	
//	@GetMapping("/administrativo/estado/estadosNome")
//	public ModelAndView buscarNome(String nome) {
//		
//		ModelAndView mv = new ModelAndView("administrativo/estado/estadoLista");
//		mv.addObject("estados", repository.buscarPorNome(nome));
//		
//		return mv;
//	}

	@GetMapping("/administrativo/ficha/adicionarFicha")
	public ModelAndView add(Ficha ficha, Enderecos enderecos, Amostra amostra, Depositos depositos, Tratamento tratamento) {
		ModelAndView mv = new ModelAndView("/administrativo/ficha/fichaAdicionar");
		
		
		mv.addObject("ficha", ficha);
		// lista - itens de Entrada vai para dentro da lista, que vai ser exibido na tela
		mv.addObject("listaEnderecos", this.listaEnderecos);
		mv.addObject("enderecos", enderecos);
		mv.addObject("amostra", amostra);
		mv.addObject("depositos", depositos);
		mv.addObject("tratamento", tratamento);
		mv.addObject("cidades", cidadeRepository.findAll());
		mv.addObject("funcionarios", funcionarioRepository.findAll());
		mv.addObject("enderecoss", listaEnderecos);
		//mv.addObject("produtos", produtoRepository.findAll());
		
		this.controleSalvar = "ADICAO";
		return mv;
	}
	
	@GetMapping("/administrativo/ficha/adicionarFicha2")
	public ModelAndView addFicha(Ficha ficha) {
		ModelAndView mv = new ModelAndView("/administrativo/ficha/fichaAdicionarEditar");
		this.controleSalvar = "EDICAO";
		mv.addObject("ficha", ficha);
		mv.addObject("cidades", cidadeRepository.findAll());
		mv.addObject("funcionarios", funcionarioRepository.findAll());
		mv.addObject("enderecos", enderecosRepository.buscarPorIdFicha(ficha.getId())); //itensEntrada enderecos
		return mv;
	}
	@GetMapping("/administrativo/enderecos/adicionarEnderecos")
	public ModelAndView addEnderecos(Enderecos enderecos) {
		ModelAndView mv = new ModelAndView("/administrativo/ficha/enderecosEditar"); 
		mv.addObject("enderecos", enderecos);
		mv.addObject("amostras", amostraRepository.buscarPorIdEnderecos(enderecos.getId()));
		mv.addObject("tratamentos", tratamentoRepository.buscarPorIdEnderecos(enderecos.getId()));
		mv.addObject("depositos", depositosRepository.buscarPorIdEnderecos(enderecos.getId()));
		return mv;
	}
	@GetMapping("/administrativo/amostra/adicionarAmostra")
	public ModelAndView addAmostra(Amostra amostra) {
		ModelAndView mv = new ModelAndView("/administrativo/ficha/amostraEditar");
		mv.addObject("amostra", amostra);
		return mv;
	}
	@GetMapping("/administrativo/tratamento/adicionarTratamento")
	public ModelAndView addTratamento(Tratamento tratamento) {
		ModelAndView mv = new ModelAndView("/administrativo/ficha/tratamentoEditar");
		mv.addObject("tratamento", tratamento);
		return mv;
	}
	@GetMapping("/administrativo/depositos/adicionarDepositos")
	public ModelAndView addDepositos(Depositos depositos) {
		ModelAndView mv = new ModelAndView("/administrativo/ficha/depositosEditar");
		mv.addObject("depositos", depositos);
		return mv;
	}
	@GetMapping("/administrativo/ficha/editarFicha/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<Ficha> ficha = fichaRepository.findById(id);
		Ficha e = ficha.get();
		return addFicha(e);
	}
	
	@GetMapping("/administrativo/ficha/continuarFicha/{id}")
	public ModelAndView editContinuarFicha(@PathVariable("id") Long id) {
		Optional<Ficha> ficha = fichaRepository.findById(id);
		Ficha e = ficha.get();
		this.listaEnderecos =  enderecosRepository.buscarPorIdFicha(e.getId());
		return add(e, new Enderecos(), new Amostra(), new Depositos(), new Tratamento());
	}
	
	@GetMapping("/administrativo/enderecos/editarEnderecos/{id}")
	public ModelAndView editEnderecos(@PathVariable("id") Long id) {
		Optional<Enderecos> enderecos = enderecosRepository.findById(id);
		Enderecos e = enderecos.get();	
		return addEnderecos(e);
	}
	
	@GetMapping("/administrativo/amostra/editarAmostra/{id}")
	public ModelAndView editAmostra(@PathVariable("id") Long id) {
		Optional<Amostra> amostra = amostraRepository.findById(id);
		Amostra e = amostra.get();	
		return addAmostra(e);
	}
	@GetMapping("/administrativo/tratamento/editarTratamento/{id}")
	public ModelAndView editTratamento(@PathVariable("id") Long id) {
		Optional<Tratamento> tratamento = tratamentoRepository.findById(id);
		Tratamento e = tratamento.get();	
		return addTratamento(e);
	}
	@GetMapping("/administrativo/depositos/editarDepositos/{id}")
	public ModelAndView editDepositos(@PathVariable("id") Long id) {
		Optional<Depositos> depositos = depositosRepository.findById(id);
		Depositos e = depositos.get();	
		return addDepositos(e);
	}
	
	
	
//	@GetMapping("/administrativo/estado/removerEstado/{id}")
//	public ModelAndView delete(@PathVariable("id") Long id) {
//		
//		Optional<Estado> estado = repository.findById(id);
//		Estado e = estado.get();
//		repository.delete(e);	
//		
//		return buscarTodos();
//	}
	
	@GetMapping("/administrativo/ficha/removerFicha/{id}")
	public ModelAndView deleteFicha(@PathVariable("id") Long id) {
		
		Optional<Ficha> ficha = fichaRepository.findById(id);
		Ficha e = ficha.get();
		
		ArrayList<Enderecos> listEnderecos = (ArrayList<Enderecos>) enderecosRepository.buscarPorIdFicha(e.getId());
		for(Enderecos it : listEnderecos) {
			Long idEndereco = it.getId();
		
			ArrayList<Amostra> listAmostra = (ArrayList<Amostra>) amostraRepository.buscarPorIdEnderecos(it.getId());
			for(Amostra am : listAmostra) {
				
				amostraRepository.delete(am);
			}
			ArrayList<Tratamento> listTrat = (ArrayList<Tratamento>) tratamentoRepository.buscarPorIdEnderecos(it.getId());
			for(Tratamento trat : listTrat) {
				
				tratamentoRepository.delete(trat);
			}
			ArrayList<Depositos> listDep = (ArrayList<Depositos>) depositosRepository.buscarPorIdEnderecos(it.getId());
			for(Depositos dp : listDep) {
				
				depositosRepository.delete(dp);
			}
			
			enderecosRepository.delete(it);
		}
		
		fichaRepository.delete(e);
		return buscarTodos();
	}
	@GetMapping("/administrativo/enderecos/removerEnderecos/{id}")
	public ModelAndView deleteEnderecos(@PathVariable("id") Long id) {
		
		Optional<Enderecos> enderecos = enderecosRepository.findById(id);
		Enderecos e = enderecos.get();
		long idFicha = e.getFicha().getId();

			ArrayList<Amostra> listAmostra = (ArrayList<Amostra>) amostraRepository.buscarPorIdEnderecos(e.getId());
			for(Amostra am : listAmostra) {
				
				amostraRepository.delete(am);
			}
			ArrayList<Tratamento> listTrat = (ArrayList<Tratamento>) tratamentoRepository.buscarPorIdEnderecos(e.getId());
			for(Tratamento trat : listTrat) {
				
				tratamentoRepository.delete(trat);
			}
			ArrayList<Depositos> listDep = (ArrayList<Depositos>) depositosRepository.buscarPorIdEnderecos(e.getId());
			for(Depositos dp : listDep) {
				
				depositosRepository.delete(dp);
			}
			
			enderecosRepository.delete(e);
			
			if (controleSalvar == "ADICAO") {
				return editContinuarFicha(idFicha);
			}else if (controleSalvar == "EDICAO") {
				return edit(idFicha);
			}
			return null;
	}
	@GetMapping("/administrativo/amostra/removerAmostra/{id}")
	public ModelAndView deleteAmostra(@PathVariable("id") Long id) {
		Optional<Amostra> amostra = amostraRepository.findById(id);
		Amostra e = amostra.get();
		long idEndereco = e.getEnderecos().getId();
		amostraRepository.delete(e);
		return editEnderecos(idEndereco);
	}
	@GetMapping("/administrativo/tratamento/removerTratamento/{id}")
	public ModelAndView deleteTratamento(@PathVariable("id") Long id) {
		Optional<Tratamento> tratamento = tratamentoRepository.findById(id);
		Tratamento e = tratamento.get();
		long idEndereco = e.getEnderecos().getId();
		tratamentoRepository.delete(e);
		return editEnderecos(idEndereco);
	}
	@GetMapping("/administrativo/depositos/removerDepositos/{id}")
	public ModelAndView deleteDepositos(@PathVariable("id") Long id) {
		Optional<Depositos> depositos = depositosRepository.findById(id);
		Depositos e = depositos.get();
		long idEndereco = e.getEnderecos().getId();
		depositosRepository.delete(e);
		return editEnderecos(idEndereco);
	}

	@PostMapping("/administrativo/ficha/salvarFicha")
	public ModelAndView save(String acao, Ficha ficha, Enderecos enderecos, Amostra amostra, Depositos depositos, Tratamento tratamento) {
		
		if (acao.equals("itens")) {

			fichaRepository.saveAndFlush(ficha);
			//coloquei null, pq o new não funciona
			enderecos.setId(null);
			amostra.setId(null);
			depositos.setId(null);
			tratamento.setId(null);
			
			//this.listaEnderecos.add(enderecos);
			
			
			enderecos.setFicha(ficha);
			enderecosRepository.saveAndFlush(enderecos);
			
			amostra.setEnderecos(enderecos);
			amostraRepository.saveAndFlush(amostra);
			
			depositos.setEnderecos(enderecos);
			depositosRepository.saveAndFlush(depositos);
			
			tratamento.setEnderecos(enderecos);
			tratamentoRepository.saveAndFlush(tratamento);
			this.listaEnderecos =  enderecosRepository.buscarPorIdFicha(ficha.getId());
						
			
		}else if(acao.equals("salvar")){
			this.listaEnderecos = null ;
			ficha.setFichaSalva(Boolean.TRUE);
//			for(Enderecos it : listaEnderecos) {
//				this.listaEnderecos = new ArrayList<>();
//			}
			fichaRepository.saveAndFlush(ficha);
			return add(new Ficha(), new Enderecos(), new Amostra(), new Depositos(), new Tratamento());
		}
		
		System.out.println(this.listaEnderecos.size());

		return add(ficha, new Enderecos(), new Amostra(), new Depositos(), new Tratamento());
	}
	
	
	@PostMapping("/administrativo/ficha/salvarFicha2")
	public ModelAndView saveFicha(Ficha ficha) {
			this.listaEnderecos = null ;
			fichaRepository.saveAndFlush(ficha);					
			return buscarTodos();
		
	}
	@PostMapping("/administrativo/enderecos/salvarEnderecos")
	public ModelAndView saveEnderecos(Enderecos enderecos) {

			enderecosRepository.saveAndFlush(enderecos);
			if (controleSalvar == "ADICAO") {
				return editContinuarFicha(enderecos.getFicha().getId());
			}else if (controleSalvar == "EDICAO") {
				return edit(enderecos.getFicha().getId());
			}
			return null;
		
	}
	@PostMapping("/administrativo/amostra/salvarAmostra")
	public ModelAndView saveAmostra(Amostra amostra) {

			amostraRepository.saveAndFlush(amostra);							
			return editEnderecos(amostra.getEnderecos().getId());
		
	}
	@PostMapping("/administrativo/tratamento/salvarTratamento")
	public ModelAndView saveTratamento(Tratamento tratamento) {

			tratamentoRepository.saveAndFlush(tratamento);
						
			return editEnderecos(tratamento.getEnderecos().getId());
		
	}
	@PostMapping("/administrativo/depositos/salvarDepositos")
	public ModelAndView saveDepositos(Depositos depositos) {
	
			depositosRepository.saveAndFlush(depositos);						
			return editEnderecos(depositos.getEnderecos().getId());
		
	}
	@PostMapping("/administrativo/enderecos/voltarParaFicha")
	public ModelAndView voltarParaFicha(Enderecos enderecos) {
	
		if (controleSalvar == "ADICAO") {
			return editContinuarFicha(enderecos.getFicha().getId());
		}else if (controleSalvar == "EDICAO") {
			return edit(enderecos.getFicha().getId());
		}
		return null;
		
	}
	
	
	@GetMapping("/administrativo/enderecos/voltarParaFicha/{id}")
	public ModelAndView voltarParaFicha(@PathVariable("id") Long id) {
		this.listaEnderecos = null ;
		Long idFicha = null;
		ArrayList<Enderecos> listEnderecos = (ArrayList<Enderecos>) enderecosRepository.buscarPorIdFicha(id);
		for(Enderecos end : listEnderecos) {
			idFicha = end.getFicha().getId();	
		}
		
		if (controleSalvar == "ADICAO") {
			return editContinuarFicha(idFicha);
		}else if (controleSalvar == "EDICAO") {
			return edit(idFicha);
		}
		return null;
	}

}
