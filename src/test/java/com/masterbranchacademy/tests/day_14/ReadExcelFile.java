package com.masterbranchacademy.tests.day_14;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcelFile {
    @Test
    public void readExcel() throws IOException {

        String root = System.getProperty("user.dir");
        String relativepath = "\\src\\test\\resources\\data\\Capitals.xlsx";

        String path = root + relativepath;

        // dosyayi acar
        FileInputStream fileInputStream = new FileInputStream(path);

        // excel dosyasini acar fileinputstream in yardimiyla
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // ilk sayfayi acar
        Sheet sheet = workbook.getSheetAt(0);
        
        // sayfa içindeki satirlari indexine gore almamiza yardimci olur
        Row row = sheet.getRow(1);

        // indexine gore hucredeki veriyi getirir
        Cell cell = row.getCell(0);

        System.out.println("cell = " + cell);

        String ottowa = sheet.getRow(2).getCell(1).toString();
        System.out.println("ottowa = " + ottowa);

        String freedom = sheet.getRow(3).getCell(2).toString();
        System.out.println("freedom = " + freedom);

        // ulkeleri baskentleri ile beraber map'e key value seklinde atalim
        
        int satirAdedi = sheet.getLastRowNum();
        System.out.println("satirAdedi = " + satirAdedi);
        Map<String, String>  paysEtCapital = new HashMap<>();

        for (int i = 1; i <= satirAdedi; i++) {
            String ulke = sheet.getRow(i).getCell(0).toString();
            //System.out.println("ulke = " + ulke);
            String capital = sheet.getRow(i).getCell(1).toString();
            //System.out.println("capital = " + capital);
            paysEtCapital.put(ulke, capital);
            
        }

        System.out.println("paysEtCapital = " + paysEtCapital);
        System.out.println("paysEtCapital.get(\"France\") = " + paysEtCapital.get("France"));

        fileInputStream.close();
        workbook.close();

    }
}
