package com.stackroute.plasma.controller;

import com.stackroute.plasma.domain.Evaluator;
import com.stackroute.plasma.service.EvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value="api/v1")
public class EvalController {

    EvalService evalService;
    private Evaluator eval;


    @Autowired
    public EvalController(EvalService evalService) {
        this.evalService = evalService;
    }


    @GetMapping("/content")
    public ResponseEntity<String> getHtmlContent() throws IOException {
        System.out.println(evalService.getHtmlContent());
        return new ResponseEntity<String>(evalService.getHtmlContent(), HttpStatus.CREATED);
    }

    @GetMapping("/title")
    public ResponseEntity<?> getTitle() throws IOException {
        return new ResponseEntity<>(evalService.titleTag(), HttpStatus.OK);
    }


    @GetMapping("/head")
    public ResponseEntity<?> getHead() throws IOException {
        return new ResponseEntity<>(evalService.headTag(), HttpStatus.OK);
    }

    @GetMapping("/body")
    public ResponseEntity<?> getBody() throws IOException {
        return new ResponseEntity<>(evalService.bodyTag(), HttpStatus.OK);
    }

   /* @GetMapping("/desc")
    public ResponseEntity<?> getDescription() throws IOException {
        return new ResponseEntity<>(evalService.description(), HttpStatus.OK);
    }

    @GetMapping("/key")
    public ResponseEntity<?> getKeywords() throws IOException {
        return new ResponseEntity<>(evalService.keywords(), HttpStatus.OK);
    }*/
//
//    @PostMapping("/con")
//    public ResponseEntity<?> postScore(@RequestBody Evaluator evaluator) throws IOException {
//        ResponseEntity responseEntity;
//        responseEntity = new ResponseEntity<Evaluator>(evalService.calScore(), HttpStatus.OK);
//        return responseEntity;
//    }
}
