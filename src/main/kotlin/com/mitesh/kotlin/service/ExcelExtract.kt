package com.mitesh.kotlin.service

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook
import org.springframework.stereotype.Service


@Service
class ExcelExtract{
    fun generateExcel() : Workbook{
        val columns = arrayOf("Name", "Email", "Date Of Birth", "Salary")

        val workBook = HSSFWorkbook()
        val sheet = workBook.createSheet("Employee")
        val headerRow = sheet.createRow(0)

        for (i in 0 until columns.size) {
            val cell = headerRow.createCell(i)
            cell.setCellValue(columns[i])
        }
        return workBook
    }
}