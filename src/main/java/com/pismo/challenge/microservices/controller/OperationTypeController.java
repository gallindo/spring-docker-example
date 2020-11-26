package com.pismo.challenge.microservices.controller;

import com.pismo.challenge.microservices.dto.OperationTypeDto;
import com.pismo.challenge.microservices.dto.OperationTypeResultDto;
import com.pismo.challenge.microservices.service.OperationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operationtypes")
public class OperationTypeController {

    @Autowired
    private OperationTypeService operationTypeService;

    @PostMapping
    public OperationTypeResultDto create(@RequestBody OperationTypeDto operationTypeDto) {

        return operationTypeService.create(operationTypeDto);
    }

    @GetMapping
    public List<OperationTypeResultDto> findAll() {

        return operationTypeService.findAll();
    }
}
