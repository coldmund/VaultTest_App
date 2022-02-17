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

    @RequestMapping(value="testkv1")
    public ResponseEntity<String>   testdb1(@RequestParam("str") String str) {
        System.out.println("input: " + str);
        return  new ResponseEntity<String>(vaultService.testKv1(str), HttpStatus.OK);
    }

    @RequestMapping(value="testkv2")
    public ResponseEntity<String>   testdb2(@RequestParam("str") String str) {
        System.out.println("input: " + str);
        return  new ResponseEntity<String>(vaultService.testKv2(str), HttpStatus.OK);
    }

    @RequestMapping(value="testkv3")
    public ResponseEntity<String>   testdb3(@RequestParam("str") String str) {
        System.out.println("input: " + str);
        return  new ResponseEntity<String>(vaultService.testKv3(str), HttpStatus.OK);
    }

    @RequestMapping(value="testEnc")
    public ResponseEntity<String>   testEnc(@RequestParam("str") String str) {
        System.out.println("input: " + str);
        return  new ResponseEntity<String>(vaultService.testEnc(str), HttpStatus.OK);
    }

    @RequestMapping(value="testDec")
    public ResponseEntity<String>   testDec(@RequestParam("str") String str) {
        System.out.println("input: " + str);
        return  new ResponseEntity<String>(vaultService.testDec(str), HttpStatus.OK);
    }
}
