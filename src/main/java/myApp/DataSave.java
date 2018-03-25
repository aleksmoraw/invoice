package myApp;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import java.util.List;

public class DataSave {

    private static final String[] FILE_HEADER = {"Nazwa firmy", "Adres1", "Adres2", "NIP", "Numer faktury", "Data wystawienia", "Data płatności", "Kwota brutto"};

    public void saveFile(String filePath, List<String> invoiceDetailsList) {

        try {
            SpreadsheetDocument loadedExistedFile = SpreadsheetDocument.loadDocument(filePath);
            Table table = loadedExistedFile.getSheetByIndex(0);

            loadHeaders(table);
            loadInvoiceDetails(table, invoiceDetailsList);

            loadedExistedFile.save(filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void loadHeaders(Table table) {
        int rowCount = 0;
        int columnCount = 0;

        for (String header : FILE_HEADER) {
            table.getCellByPosition(columnCount++, rowCount).setStringValue(header);
        }
    }

    protected void loadInvoiceDetails(Table table, List<String> invoiceDetailsList) {

        int rowCount = table.getRowCount();
        int columnCount = 0;

        for (String detail : invoiceDetailsList) {
            table.getCellByPosition(columnCount++, rowCount).setStringValue(detail);
        }
    }
}


