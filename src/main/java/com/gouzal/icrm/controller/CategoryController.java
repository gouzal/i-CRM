package com.gouzal.icrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gouzal.icrm.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
    CategoryService categoryService;


}
