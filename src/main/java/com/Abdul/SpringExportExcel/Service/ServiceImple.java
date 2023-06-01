package com.Abdul.SpringExportExcel.Service;

import com.Abdul.SpringExportExcel.Entity.ExcelFile;
import com.Abdul.SpringExportExcel.Repo.Repo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceImple {


    @Autowired
    Repo repo;

    public ServiceImple(Repo repo) {
        this.repo = repo;
    }


    public void generateExcel(HttpServletResponse response) throws Exception {

        List<ExcelFile> courses = repo.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Courses Info");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Price");

        int dataRowIndex = 1;

        for (ExcelFile course : courses) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(course.getCid());
            dataRow.createCell(1).setCellValue(course.getName());
            dataRow.createCell(2).setCellValue(course.getPrice());
            dataRowIndex++;
        }

        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();

    }

}
