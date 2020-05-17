package com.example.demo;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class XlsWriter {

    // Name Example for the Generator
    private static String [] LastName = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王"};
    private static String [] FirstName = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};

    // Random Generator for Salary
    public static float RandomGen(float max, float min){
        float num = min + ((max - min) * new Random().nextFloat());
        num = (float)(Math.round(num*100)/100);
        return num;
    }

    // Name Generator for Names
    public static List<String> NameGen(){
        List<String> nameList = new ArrayList<String>();
        for(int i = 0;i<8;i++){
            for(int j = 0;j<10;j++){
                nameList.add(LastName[i]+FirstName[j]);
            }
        }
        return nameList;
    }

    public static void main(String[] args) throws IOException {
        // Read the original file
        FileInputStream file = new FileInputStream("D:\\demo.xls");
        HSSFWorkbook workBook = new HSSFWorkbook(file);

        HSSFSheet sheet = workBook.cloneSheet(0);
        workBook.setSheetName(0, "April");

        // Write the file with random num
        for(int i = 0;i<80;i++){
            sheet.getRow(3+i).getCell(1).setCellValue(NameGen().get(i));
            sheet.getRow(3+i).getCell(2).setCellValue(RandomGen(8000f, 3000f));
            sheet.getRow(3+i).getCell(3).setCellValue(RandomGen(3000f, 2000f));
            sheet.getRow(3+i).getCell(4).setCellValue(RandomGen(800f, 300f));
            sheet.getRow(3+i).getCell(5).setCellValue(RandomGen(500f, 300f));
            sheet.getRow(3+i).getCell(6).setCellValue(RandomGen(100f, 50f));
            sheet.getRow(3+i).getCell(7).setCellValue(RandomGen(100f, 50f));
            sheet.getRow(3+i).getCell(8).setCellValue(RandomGen(200f, 100f));
            sheet.getRow(3+i).getCell(9).setCellValue(RandomGen(200f, 100f));
            sheet.getRow(3+i).getCell(10).setCellValue(RandomGen(200f, 100f));
            // 应发总数
            sheet.getRow(3+i).getCell(11).setCellFormula("sum(C"+(4+i)+":K"+(4+i)+")");

            sheet.getRow(3+i).getCell(12).setCellValue(RandomGen(400f, 100f));
            sheet.getRow(3+i).getCell(13).setCellValue(RandomGen(400f, 100f));
            sheet.getRow(3+i).getCell(14).setCellValue(RandomGen(400f, 100f));
            sheet.getRow(3+i).getCell(15).setCellValue(RandomGen(400f, 100f));
            sheet.getRow(3+i).getCell(16).setCellValue(RandomGen(400f, 100f));
            sheet.getRow(3+i).getCell(17).setCellValue(RandomGen(400f, 100f));
            sheet.getRow(3+i).getCell(18).setCellValue(RandomGen(400f, 100f));
            sheet.getRow(3+i).getCell(19).setCellValue(RandomGen(400f, 100f));
            // 扣款合计
            sheet.getRow(3+i).getCell(20).setCellFormula("sum(M"+(4+i)+":T"+(4+i)+")");

            // 实发工资
            sheet.getRow(3+i).getCell(21).setCellFormula("sum(L"+(4+i)+"-U"+(4+i)+")");
        }

        // Set the cell style
        for(int i =3;i<=83;i++){
            for(int j = 1;j<=21;j++){
                HSSFCellStyle style = workBook.createCellStyle();
                style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
                sheet.getRow(i).getCell(j).setCellStyle(style);
            }
        }

        // Output the file
        String fileName = "test" + System.currentTimeMillis() + ".xls";
        OutputStream out = new FileOutputStream("E:" + "/" + fileName);
        workBook.removeSheetAt(0);
        workBook.write(out);

        file.close();
        out.flush();
        out.close();
    }

}
