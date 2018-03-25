package myApp;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataLoad {

    public File createFile(String pathToFile) {
        return new File(pathToFile);
    }

    public Table loadFile(File file) throws Exception {
        return SpreadsheetDocument.loadDocument(file).getSheetByIndex(1);
    }

    public List<String> loadCellsIntoArray(Table table) {
        String companyName = table.getCellByPosition(6, 1).getStringValue();
        String address1 = table.getCellByPosition(6, 3).getStringValue();
        String address2 = table.getCellByPosition(6, 4).getStringValue();
        String nip = table.getCellByPosition(6, 5).getStringValue();
        String invoiceNumber = table.getCellByPosition(5, 10).getStringValue();
        String setDate = table.getCellByPosition(9, 12).getStringValue();
        String payDate = table.getCellByPosition(3, 14).getStringValue();
        String amount = table.getCellByPosition(11, 58).getStringValue();

        List<String> invoiceDetailsList = new ArrayList<>();
        invoiceDetailsList.add(companyName);
        invoiceDetailsList.add(address1);
        invoiceDetailsList.add(address2);
        invoiceDetailsList.add(nip);
        invoiceDetailsList.add(invoiceNumber);
        invoiceDetailsList.add(setDate);
        invoiceDetailsList.add(payDate);
        invoiceDetailsList.add(amount);

        return invoiceDetailsList;
    }
}

