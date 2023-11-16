package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bean.VendedorDTO;

public class ExportarEXCEL {
	
	private List<VendedorDTO> getVendedores;
	
	public ExportarEXCEL() {
		// TODO Auto-generated constructor stub
	}
	
	public ExportarEXCEL(List<VendedorDTO> getVendedores) {
		this.getVendedores=getVendedores;
	}
	
	
	public void crearExcel() {
		Workbook libro = new XSSFWorkbook();
        Sheet hoja = libro.createSheet("Hoja 1");
        
        
        String[] encabezados= {"Codigo","Nombre","Celular","Telefono","Correo"};
        int indiceFila=0;
        
        Row fila = hoja.createRow(indiceFila);
        for (int i=0;i<encabezados.length;i++) {
        	String encabezado=encabezados[i];
        	Cell celda= fila.createCell(i);
        	celda.setCellValue(encabezado);
        }
        
        indiceFila++;
        for (int i = 0; i < getVendedores.size(); i++) {
            fila = hoja.createRow(indiceFila);
            VendedorDTO vendedor = getVendedores.get(i);
            fila.createCell(0).setCellValue(vendedor.getCodigo());
            fila.createCell(1).setCellValue(vendedor.getNombres());
            fila.createCell(2).setCellValue(vendedor.getCelular());
            fila.createCell(3).setCellValue(vendedor.getTelefono());
            fila.createCell(4).setCellValue(vendedor.getCorreo());
            indiceFila++;
        }
        
        
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream("C:\\Users\\Usuario\\Desktop\\Excel.xlsx");
            libro.write(outputStream);
            libro.close();
            System.out.println("Libro guardado correctamente");
        } catch (FileNotFoundException ex) {
            System.out.println("Error de filenotfound");
        } catch (IOException ex) {
            System.out.println("Error de IOException");
        }
	}
}
