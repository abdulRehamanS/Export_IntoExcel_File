package com.Abdul.SpringExportExcel.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "ExcelReportJava")
public class ExcelFile {


    @Id
    Integer cid;

    String name;

    String course;

    Long Price;
}
