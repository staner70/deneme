package com.masterbranchacademy.tests.day_14;

import com.masterbranchacademy.pages.DataTablesPage;
import com.masterbranchacademy.utilities.BaseTest;
import com.masterbranchacademy.utilities.ConfigReader;
import com.masterbranchacademy.utilities.GetDataFromExcel;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelRead extends BaseTest {

    GetDataFromExcel dataFromExcel = new GetDataFromExcel();
    DataTablesPage dataTable = new DataTablesPage();

    @Test
    public void excelRead() throws IOException, InterruptedException {

        String root = System.getProperty("user.dir");
        String relativepath = "\\src\\test\\resources\\data\\exceldata.xlsx";

        String path = root + relativepath;
        List<Map<String, String>> dataList = dataFromExcel.getDataList(path);

        System.out.println("dataList.get(3) = " + dataList.get(3));
        for (Map<String, String> stringMap : dataList) {
            driver.get(ConfigReader.getProperties("url"));
            dataTable.newButton.click();
            dataTable.firstName.sendKeys(stringMap.get("firstname"));
            dataTable.lastName.sendKeys(stringMap.get("lastname"));
            dataTable.position.sendKeys(stringMap.get("position"));
            dataTable.office.sendKeys(stringMap.get("office"));
            dataTable.extension.sendKeys(stringMap.get("extension"));
            dataTable.startDate.sendKeys(stringMap.get("startdate"));
            dataTable.day.click();
            dataTable.salary.sendKeys(stringMap.get("salary"));
            dataTable.createButton.click();
            dataTable.searchBox.sendKeys(stringMap.get("firstname"));
            Thread.sleep(2000);
            Assert.assertTrue(dataTable.nameField.getText().contains(stringMap.get("firstname")));
        }

    }
}
