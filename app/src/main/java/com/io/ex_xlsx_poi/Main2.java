package com.io.ex_xlsx_poi;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *  Apache POI 라이브러리를 이용한
 *  xlsx 입출력 구현하기
 *  |temp
 *  ㄴ data.xlsx
 *      ㄴ Sheet : user
 *      ㄴ Sheet : project
 *
 *
 */

public class Main2 {

    public static String filePath = "app/src/main/java/com/io/ex_xlsx_poi/temp";
    public static String fileName = "data.xlsx";
    public static String fileFullName = filePath+"/"+fileName;

    // Line
    public static void Line(){
        final String LINE = "----------------------------------------";
        System.out.println(LINE);
    }

    public static void main(String[] args) throws Exception{

        Line();

        // XSSF 세팅
        System.out.println("입력 시작");
        XSSFWorkbook workbook = new XSSFWorkbook(fileFullName);
        // 시트 정보 가져오기
        XSSFSheet userSheet2 = workbook.getSheet("user");
        XSSFSheet projectSheet2 = workbook.getSheet("project");

        // 터미널 출력해보기
        // 첫 줄은 정보가 있기때문에 생략해도 된다. (i=1)
        for(int i = 0; i <= userSheet2.getLastRowNum(); i++){
            Row row = userSheet2.getRow(i);
                System.out.printf("%s %s %s\n",
                    row.getCell(0).getStringCellValue(),
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue()
                );
        }
        System.out.println("!! 유저 출력 완료 !!");
        Line();

        // 터미널 출력해보기
        for(int i = 0; i <= projectSheet2.getLastRowNum(); i++) {
            Row row = projectSheet2.getRow(i);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            System.out.printf("%s %s %s %s %s\n",
                row.getCell(0).getStringCellValue(),
                row.getCell(1).getStringCellValue(),
                row.getCell(2).getStringCellValue(),
                row.getCell(3).getStringCellValue(),
                row.getCell(4).getStringCellValue()

               );
        }
        System.out.println("!! 프로젝트 출력 완료 !!");
    }
}
