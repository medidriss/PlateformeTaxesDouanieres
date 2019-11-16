package com.enit.data.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.enit.entites.Taxe;

public class TaxesDAO {
    public static final String FILE_NAME = "C:\\Users\\lenovo\\Desktop\\Cour\\PFA2\\PFA DOC\\DOC CHAPITRES/Taxes.xlsx";
    private static Map<String, com.enit.entites.Taxe> taxes = new HashMap<>();


    public static Map<String, Taxe> getTaxes() {
        if (taxes.isEmpty()) {
            try {
                FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
                Workbook workbook = new XSSFWorkbook(excelFile);
                Sheet datatypeSheet = workbook.getSheetAt(0);
                Iterator<Row> iterator = datatypeSheet.iterator();
                iterator.next();
                while (iterator.hasNext()) {
                    Row currentRow = iterator.next();
                    String code = ExcelUtils.getCellValueAsString(currentRow.getCell(0));
                    if (code.isEmpty()) {
                        break;
                    }
                    String designation = ExcelUtils.getCellValueAsString(currentRow.getCell(1));
                    ;
                    String assiettes_str = ExcelUtils.getCellValueAsString(currentRow.getCell(2));
                    List<Character> assiettes = new ArrayList<Character>();
                    if (assiettes_str.length() == 0) {
                        //pas d'assietttes
                    } else if (assiettes_str.length() == 1) {
                        assiettes.add(assiettes_str.charAt(0));
                    } else {
                        assiettes = Arrays.asList(assiettes_str.split("/")).stream().map(s -> s.charAt(0)).collect(Collectors.toList());
                    }
                    Taxe t = new Taxe(code, designation, assiettes);

                    taxes.put(t.getCode(), t);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return taxes;

    }

}
