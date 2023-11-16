package utils;

import java.awt.Color;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import bean.ClienteDTO;

public class ExportarPDF {
	private List<ClienteDTO> getClientes;
	
	public ExportarPDF() {
		
	}
	
	public ExportarPDF(List<ClienteDTO> getClientes) {
		this.getClientes=getClientes;
	}
	
	public void writeHeader(PdfPTable pdfTable) {
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(Color.darkGray);
		cell.setPadding(6);
		Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(Color.white);
		
		cell.setPhrase(new Phrase("CODIGO",font));
		pdfTable.addCell(cell);
		cell.setPhrase(new Phrase("CORREO",font));
		pdfTable.addCell(cell);
		cell.setPhrase(new Phrase("NOMBRES",font));
		pdfTable.addCell(cell);
		cell.setPhrase(new Phrase("APELLIDOS",font));
		pdfTable.addCell(cell);
		cell.setPhrase(new Phrase("CELULAR",font));
		pdfTable.addCell(cell);
	}
	
	public void writeTableData(PdfPTable pTable) {
		for(ClienteDTO cliente: getClientes) {
			pTable.addCell(String.valueOf(cliente.getCodigo()));
			pTable.addCell(String.valueOf(cliente.getCorreo()));
			pTable.addCell(String.valueOf(cliente.getNombres()));
			pTable.addCell(String.valueOf(cliente.getApellidos()));
			pTable.addCell(String.valueOf(cliente.getCelular()));
		}
	}
	
	public void export(HttpServletResponse response) {
		try {
			Document document=new Document(PageSize.A4);
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			
			Font font=FontFactory.getFont(FontFactory.HELVETICA);
			font.setSize(20);
			font.setColor(Color.BLACK);
			
			Paragraph paragraph= new Paragraph("Lista de Clientes",font);
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph);
			
			
			PdfPTable table= new PdfPTable(5);
			table.setWidthPercentage(100f);
			table.setWidths(new float[]{2.0f,3.5f,3.5f,3.5f,3.0f});
			table.setSpacingBefore(10);
			
			writeHeader(table);
			writeTableData(table);
			
			document.add(table);
			document.close();
			
		} catch (Exception e) {
			System.err.println("Error,"+e);
		}
	}
}
