package com.gouzal.icrm.controller;

import com.gouzal.icrm.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gouzal.icrm.service.ProviderService;

@RestController
public class ProviderController {

	@Autowired
    ProviderService providerService;
	
	@Autowired
    CityService cityService;


}
