package ACS_CRMN;

 	
	import java.io.File;
	import java.io.IOException;

	import jxl.Cell;
	import jxl.Sheet;
	import jxl.Workbook;
	import jxl.read.biff.BiffException;

	public class AALabMain {
		
 
		 static String file = "c:/experiment.xls" ;

		  public static void main(String[] args) throws IOException {
		 
	 		   read(file);
		  }
		 
		  
		  
		  
		  
		public static void read(String inputFile) throws IOException  {
	    File inputWorkbook = new File(inputFile);
	    Workbook w;
	    try {
	      w = Workbook.getWorkbook(inputWorkbook);
	      
	      Sheet sheet = w.getSheet(0);
	    	      
   for (int j = 0; j < sheet.getColumns(); j++) {
	      for (int i = 0; i < sheet.getRows()-1; i++) {
	        Cell cell = sheet.getCell( i,j);
	        System.out.println(cell.getContents());
	      }
	   }
	    } catch (BiffException e) {
	      e.printStackTrace();
	    }
	  }


	} 
	
 