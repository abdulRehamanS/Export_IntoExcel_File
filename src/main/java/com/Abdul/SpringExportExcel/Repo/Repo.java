package com.Abdul.SpringExportExcel.Repo;

import com.Abdul.SpringExportExcel.Entity.ExcelFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface Repo extends JpaRepository <ExcelFile , Serializable>{
}
