package com.mitesh.kotlin.Controller

import com.mitesh.kotlin.service.ExcelExtract
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse


@RestController
class ExcelExtractController(
        private val excelExtractor: ExcelExtract
){

    @GetMapping("/excel/download")
    @ResponseBody
    fun generateExcel(response: HttpServletResponse){

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=sample-spreadsheet.xls");

        excelExtractor.generateExcel().write(response.outputStream)
    }

}