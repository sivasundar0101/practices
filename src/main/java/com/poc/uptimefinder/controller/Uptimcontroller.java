package com.poc.uptimefinder.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.uptimefinder.model.URLentity;
import com.poc.uptimefinder.services.ServiceInterface;


@RestController
@RequestMapping("/api/v1")
public class Uptimcontroller {
	
	ServiceInterface serviceInterface;
	public Uptimcontroller(ServiceInterface serviceInterface) {
		this.serviceInterface=serviceInterface;
	}
		
	
	@GetMapping
	public ResponseEntity<List<URLentity>> getall(){
		List<URLentity> urlentity = serviceInterface.getAllURL();
		System.out.println("inside");
		return new ResponseEntity<>(urlentity,HttpStatus.OK) ;
	}
	
	@GetMapping({"/{URLid}"})
    public ResponseEntity<URLentity> get(@PathVariable Long id) {
        return new ResponseEntity<>(serviceInterface.getURLById(id), HttpStatus.OK);
    }
	
	@PostMapping
	public ResponseEntity<URLentity> add(@RequestBody URLentity urLentity) {
        URLentity urlLentity1 = serviceInterface.add(urLentity);
        HttpHeaders httpHeaders =new HttpHeaders();
        httpHeaders.add("URLentity", "/api/v1/urlentity/" + urlLentity1.getId());
        return new ResponseEntity<>(urlLentity1, httpHeaders, HttpStatus.CREATED);
    }
	@PutMapping({"/{URLid}"})
    public ResponseEntity<URLentity> update(@PathVariable("URLid") Long id, @RequestBody URLentity urLentity) {
        serviceInterface.updateURL(id, urLentity);
        return new ResponseEntity<>(serviceInterface.getURLById(id), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the Todo with the specified Id.
    @DeleteMapping({"/{URLid}"})
    public ResponseEntity<URLentity> delete(@PathVariable("URlid") Long id) {
        serviceInterface.deleteURL(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
