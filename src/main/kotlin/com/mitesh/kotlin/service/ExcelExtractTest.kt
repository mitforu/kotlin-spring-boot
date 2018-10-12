package com.mitesh.kotlin.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ExcelExtractTest{

    @Test
    fun `it should return excel workbook with header`(){
        val subject = ExcelExtract()
        val workbook = subject.generateExcel()
        assertThat(workbook.numberOfSheets).isEqualTo(1)
    }

    @Test
    fun `should have headers`(){
        val subject = ExcelExtract()
        val workbook = subject.generateExcel()
        val sheet = workbook.getSheetAt(0)

        val row = sheet.getRow(0)
        assertThat(row.getCell(0).stringCellValue).isEqualTo("Name")
        assertThat(row.getCell(1).stringCellValue).isEqualTo("Email")
        assertThat(row.getCell(2).stringCellValue).isEqualTo("Date Of Birth")
        assertThat(row.getCell(3).stringCellValue).isEqualTo("Salary")
    }
}
