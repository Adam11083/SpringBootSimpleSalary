package com.example.demo;

import com.example.demo.Model.DeductPayModel;
import com.example.demo.Model.NetPayModel;
import com.example.demo.Model.PersonSalaryModel;
import com.example.demo.Repository.PersonSalaryRepository;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

@Component
public class DBSeeder implements CommandLineRunner {

    // Add Repository
    private PersonSalaryRepository personSalaryRepository;


    public DBSeeder(PersonSalaryRepository personSalaryRepository) {
        this.personSalaryRepository = personSalaryRepository;
    }


    // Adding records into DB
    @Override
    public void run(String... args) throws Exception {

        // drop all former people
        this.personSalaryRepository.deleteAll();

        // Read the original file
        FileInputStream file = new FileInputStream("D:\\data.xls");
        HSSFWorkbook workBook = new HSSFWorkbook(file);

        HSSFSheet sheet = workBook.cloneSheet(0);
        workBook.setSheetName(0, "April");

        for(int i =3;i<=83;i++){

            PersonSalaryModel NewPerson = new PersonSalaryModel(
                    sheet.getRow(i).getCell(1).getStringCellValue(),
                    new NetPayModel(
                            (float)sheet.getRow(i).getCell(2).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(3).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(4).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(5).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(6).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(7).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(8).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(9).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(10).getNumericCellValue()
                    ),
                    new DeductPayModel(
                            (float)sheet.getRow(i).getCell(12).getNumericCellValue(),
                            (float) sheet.getRow(i).getCell(13).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(14).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(15).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(16).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(17).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(18).getNumericCellValue(),
                            (float)sheet.getRow(i).getCell(19).getNumericCellValue()
                    )
            );
            this.personSalaryRepository.save(NewPerson);
        }
    }
}
