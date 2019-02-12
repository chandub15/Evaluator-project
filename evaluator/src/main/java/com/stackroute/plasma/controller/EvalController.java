package com.stackroute.plasma.controller;

import com.stackroute.plasma.domain.Evaluator;
import com.stackroute.plasma.service.EvalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value="api/v1")
public class EvalController {

        Evaluator evaluator;

    @GetMapping("http-content")
    public ResponseEntity<?> getContent() throws IOException {
        return new ResponseEntity<Evaluator>(EvalService.getHttpContent(), HttpStatus.OK);
    }
}
