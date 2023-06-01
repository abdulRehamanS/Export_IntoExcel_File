package com.Abdul.SpringExportExcel.Controller;


import com.Abdul.SpringExportExcel.Service.ServiceImple;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    ServiceImple service;

    public Controller(ServiceImple service) {
        this.service = service;
    }

    @GetMapping("/excel")
    public void generateExcelReport(HttpServletResponse response) throws Exception {

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=courses.xls";

        response.setHeader(headerKey, headerValue);


        service.generateExcel(response);

        response.flushBuffer();
    }

}
