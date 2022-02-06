package com.example.vaulttest.controller;

import com.example.vaulttest.service.VaultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/")
public class ApiController {
    @Autowired
    VaultService    vaultService;

    @RequestMapping(value="testdb1")
    public ResponseEntity<String>   testdb1(@RequestParam("str") String str) {
        System.out.println("input: " + str);
        return  new ResponseEntity<String>(vaultService.testDb1(str), HttpStatus.OK);
    }
}