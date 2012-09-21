import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Excel {
       public static void main(String[] args) {
                 String fileName = "H:\\IMACROS\\XM-CREATOR\\jags.xls";
                 Vector dataHolder = ReadCSV(fileName,0);
                 
                 
                 for (int i = 1; i < dataHolder.size(); i++) {
                        Vector cellStoreVector = (Vector) dataHolder.elementAt(i);
                        ArrayList<String> values = new ArrayList<String>();
                           for (int j = 0; j < cellStoreVector.size(); j++) {
                                 HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
                                String stringCellValue = myCell.toString();
                                 values.add(stringCellValue);
                        }
                           System.out.print(values.get(0));
                          System.out.print(values.get(1));
                          System.out.print(values.get(2));
                          System.out.print(values.get(3));
                          System.out.print(values.get(4));
                          System.out.print("----------Do Some Thing");
                  }
          }
        
 public static Vector ReadCSV(String fileName, int sheet) {
    Vector cellVectorHolder = new Vector();

    try {
            FileInputStream myInput = new FileInputStream(fileName);

            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

            HSSFSheet mySheet = myWorkBook.getSheetAt(sheet);

            Iterator rowIter = mySheet.rowIterator();

            while (rowIter.hasNext()) {
                    HSSFRow myRow = (HSSFRow) rowIter.next();
                    Iterator cellIter = myRow.cellIterator();
                    Vector cellStoreVector = new Vector();
                    while (cellIter.hasNext()) {
                            HSSFCell myCell = (HSSFCell) cellIter.next();
                            cellStoreVector.addElement(myCell);
                    }
                    cellVectorHolder.addElement(cellStoreVector);
            }
    } catch (Exception e) {
            e.printStackTrace();
    }
    return cellVectorHolder;
}}