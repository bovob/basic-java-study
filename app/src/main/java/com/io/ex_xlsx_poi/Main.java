package com.io.ex_xlsx_poi;

import java.io.File;
import java.io.FileOutputStream;
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

public class Main {

    public static String filePath = "app/src/main/java/com/io/ex_xlsx_poi/temp";
    public static String fileName = "data.xlsx";
    public static String fileFullName = filePath+"/"+fileName;

    // Line
    public static void Line(){
        final String LINE = "----------------------------------------";
        System.out.println(LINE);
    }

    public static void main(String[] args) throws Exception{

        // 디렉터리 생성
        File dir = new File(filePath);
        if (!dir.exists()){
            dir.mkdir();
           System.out.println(fileName+"을 생성하였습니다.");
        } else {
            System.out.println(fileName+"이 이미 존재합니다.");
        }

        Line();

        // XSSF 세팅
        // WorkBook - 파일
        // Sheet - 엑셀 시트
        System.out.println("출력시작");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet userSheet = workbook.createSheet("user");
        XSSFSheet projectSheet = workbook.createSheet("project");

        // Sheet 데이터
        List<Object[]> userData = new ArrayList<>();

        // 1행 데이터목록
        userData.add(new Object[]{"no", "name", "tel"});
        // 더미 데이터
        userData.add(new Object[]{"1", "홍길동", "010-1111-2222"});
        userData.add(new Object[]{"2", "유관순", "010-1234-2222"});
        userData.add(new Object[]{"3", "윤봉길", "010-1111-1234"});

        // 행 번호 초기화
        int rownum = 0;
        // 행 반복
        for (int i = 0; i < userData.size() ; i++){
            Object[] values = userData.get(i);
            Row row = userSheet.createRow(rownum++);
            // 열 입력 반복
            for(int j = 0; j<values.length; j++){
                row.createCell(j).setCellValue((String) values[j]);
            }
        }

        try (FileOutputStream out = new FileOutputStream(fileFullName)){
            workbook.write(out);
        }


        // Sheet 데이터
        List<Object[]> projectData = new ArrayList<>();

        // 1행 데이터목록
        projectData.add(new Object[]{"no", "project", "start_date", "end_date", "member"});
        // 더미 데이터
        projectData.add(new Object[]{"1", "입출력하기", "2024-01-01 15:30:23","2024-06-31 07:08:09","1,3"});
        projectData.add(new Object[]{"2", "자바마스터", "2024-01-01 01:00:23","2024-12-31 23:58:39","2"});

        // 행 번호 초기화
        int rownum2 = 0;
        // 행 반복
        for (int i = 0; i < projectData.size() ; i++){
            Object[] values = projectData.get(i);
            Row row = projectSheet.createRow(rownum2++);
            // 열 입력 반복
            for(int j = 0; j<values.length; j++){
                row.createCell(j).setCellValue((String) values[j]);
            }
        }
        try (FileOutputStream out = new FileOutputStream(fileFullName)){
            workbook.write(out);
        }
    }
}
