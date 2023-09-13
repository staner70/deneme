package com.masterbranchacademy.tests.day_14;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelFile {
    @Test
    public void writeExcel() throws IOException {
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
        Row row = sheet.getRow(0);

        // hucreyi olusturur
        Cell cell = row.createCell(4);

        //hucreye yaziyi yazar
        cell.setCellValue("Area");

        //Fransa population yazacak
        sheet.getRow(1).createCell(4).setCellValue("350");
        sheet.getRow(2).createCell(4).setCellValue("450");
        sheet.getRow(3).createCell(4).setCellValue("780");

        // FileOutputStream excele verileri yazmamiza yardimci olur
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);



        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();
    }
}
