package com.qorri.service;

import com.qorri.dto.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.io.InputStream;
import java.util.*;

@ApplicationScoped
@Transactional
public class ExcelService {
    public ResponseDTO uploadExcel(InputStream req){
        try {
            Workbook workbook = new XSSFWorkbook(req);
            Sheet sheet = workbook.getSheetAt(0);

            List<ExcelResponseDTO> dataList = new ArrayList<>();
            for (Row row : sheet) {
                if (row.getRowNum() == 0) { // Skip header row
                    continue;
                }
                ExcelResponseDTO dataMap = new ExcelResponseDTO();
                dataMap.setId((int) row.getCell(0).getNumericCellValue());
                dataMap.setName(row.getCell(1).getStringCellValue());
                dataMap.setGender(row.getCell(2).getStringCellValue());
                dataMap.setCountry(row.getCell(3).getStringCellValue());
                dataList.add(dataMap);
            }

            return new ResponseDTO<>().successResponse(dataList,"Data has been successfully encrypted");
        } catch (Exception e) {
            return new ResponseDTO<>().errorResponse(204,"File processing error");
        }
    }
}
