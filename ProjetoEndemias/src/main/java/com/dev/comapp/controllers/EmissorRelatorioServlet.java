//package com.dev.comapp.controllers;
//
//import java.sql.Connection;
//import java.util.HashMap;
//
//import javax.servlet.http.HttpServlet;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.itextpdf.text.pdf.codec.Base64.InputStream;
//
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//
//
//public class EmissorRelatorioServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    
//    @Autowired
//    private DataSource dataSource;
//
//    public EmissorRelatorioServlet() {
//      super();
//    }
//    
//    @GetMapping("/administrativo/ficha/imprimirFicha/{id}")
//	public byte[] imprimirFicha(@PathVariable("id") Long id) throws Exception {
//
//		HashMap<String, Object> parametros = new HashMap<>();
//		parametros.put("format", "pdf");
//		parametros.put("id_da_ficha", 20);
//
////		InputStream inputStream = this.getClass().getResourceAsStream("C:/Users/Luiz Gustavo/Desktop/report1.jasper");
//		
//		String caminhoRelJasper = "C:\\Users\\Luiz Gustavo\\Desktop\\report1.jasper";
//
//		InputStream inputStream = (InputStream) EmissorRelatorioServlet.class.getResourceAsStream(caminhoRelJasper);
//
//		Connection con = this.dataSource.getConnection();
//
//		try {
//		JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros, con);
//		return JasperExportManager.exportReportToPdf(jasperPrint);
//		} finally {
//		con.close();
//		}
//		}
//}
