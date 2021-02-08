package com.dev.comapp.controllers;

import java.io.OutputStream;
import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dev.comapp.Conexao;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.comapp.Conexao;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
@Controller
public class RelatorioController implements Serializable{
	private static final long serialVersionUID = 1L;
	@Autowired
	ServletContext context;
	
	@GetMapping("/administrativo/ficha/imprimirFicha/{id}")
	public void imprimirFicha(@PathVariable("id") Long id, HttpServletResponse response) throws Exception {
			try {
				
				HashMap<String, Object> parametros = new HashMap<>();
				parametros.put("id_da_ficha", id);
				InputStream stream = this.getClass().getResourceAsStream("/relatorioFicha.jrxml");

				JasperReport report = JasperCompileManager.compileReport(stream);
				JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros,
						Conexao.getConection());
				
				response.setContentType("application/pdf");
			    response.setHeader("Content-disposition", "attachement; filename=\"Relatório de Ficha.pdf\"");

			    final OutputStream outStream = response.getOutputStream();
			    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
