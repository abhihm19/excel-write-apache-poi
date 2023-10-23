package com.sillyproject.excelwriteapachepoi.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.sillyproject.excelwriteapachepoi.entity.Employee;

@Service
public class WriteService {

	public String writeData() {
	    List<Employee> employees = getEmployeeData();
	    //System.out.println(employees);
	    try (Workbook workbook = new XSSFWorkbook();
	         FileOutputStream fileOutputStream = new FileOutputStream("output-excel.xlsx")) {

	        Sheet sheet = workbook.createSheet("Sheet1");
	        Row headerRow = sheet.createRow(0);

	        String[] headers = {"id", "name", "email_id", "DOB", "DOJ"};
	        for (int i = 0; i < headers.length; i++) {
	            headerRow.createCell(i).setCellValue(headers[i]);
	        }

	        int rowNumber = 1;
	        for (Employee employee : employees) {
	            Row dataRow = sheet.createRow(rowNumber++);
	            dataRow.createCell(0).setCellValue(employee.getId());
	            dataRow.createCell(1).setCellValue(employee.getName());
	            dataRow.createCell(2).setCellValue(employee.getEmailId());
	            dataRow.createCell(3).setCellValue(employee.getDateOfBirth());
	            dataRow.createCell(4).setCellValue(employee.getDateOfJoining());
	        }

	        workbook.write(fileOutputStream);
	        return "Excel file created successfully";

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	        return "Error: File not found";
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "Error: An IO exception occurred";
	    }
	}

	private List<Employee> getEmployeeData() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "John", "john@example.com", LocalDate.of(1995, 1, 15), LocalDateTime.of(2020, 7, 12, 9, 30)));
		employees.add(new Employee(2, "Alice", "alice@example.com", LocalDate.of(1993, 5, 8), LocalDateTime.of(2019, 10, 5, 14, 15)));
		employees.add(new Employee(3, "Bob", "bob@example.com", LocalDate.of(1989, 9, 23), LocalDateTime.of(2017, 2, 18, 11, 45)));
		employees.add(new Employee(4, "Eva", "eva@example.com", LocalDate.of(1992, 3, 17), LocalDateTime.of(2022, 12, 3, 8, 0)));
		employees.add(new Employee(5, "Mike", "mike@example.com", LocalDate.of(1994, 11, 29), LocalDateTime.of(2018, 6, 9, 16, 20)));	
        
        return employees;
	}

}
