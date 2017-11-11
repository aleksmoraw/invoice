package myApp;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import java.io.File;
import java.util.HashMap;

public class DataLoad {

    public File createFile(String pathToFile) {
        File file = new File(pathToFile);
        return file;
    }

    public Table loadFile(File file) throws Exception {
        Table table = SpreadsheetDocument.loadDocument(file).getSheetByIndex(1);
        return table;
    }

    public HashMap<String, String> loadCellsIntoMap(Table table) {
        String companyName = table.getCellByPosition(6, 1).getStringValue();
        String address1 = table.getCellByPosition(6, 3).getStringValue();
        String address2 = table.getCellByPosition(6, 4).getStringValue();
        String nip = table.getCellByPosition(6, 5).getStringValue();
        String invoiceNumber = table.getCellByPosition(5, 10).getStringValue();
        String setDate = table.getCellByPosition(9, 12).getStringValue();
        String payDate = table.getCellByPosition(3, 14).getStringValue();
        String amount = table.getCellByPosition(11, 58).getStringValue();

        HashMap<String, String> dataFromCellsMap = new HashMap<>();
        dataFromCellsMap.put("Nazwa firmy", companyName);
        dataFromCellsMap.put("Adres1", address1);
        dataFromCellsMap.put("Adres2", address2);
        dataFromCellsMap.put("NIP", nip);
        dataFromCellsMap.put("Numer faktury", invoiceNumber);
        dataFromCellsMap.put("Data wystawienia", setDate);
        dataFromCellsMap.put("Data platnosci", payDate);
        dataFromCellsMap.put("Kwota brutto", amount);

        return dataFromCellsMap;
    }
}

