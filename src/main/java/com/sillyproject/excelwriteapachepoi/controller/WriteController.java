package com.sillyproject.excelwriteapachepoi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sillyproject.excelwriteapachepoi.service.WriteService;

@RestController
public class WriteController {
	
	@Autowired
	private WriteService writeService;
	
	@GetMapping("/write")
	public String writeData() {
		return  writeService.writeData();
	}

}
