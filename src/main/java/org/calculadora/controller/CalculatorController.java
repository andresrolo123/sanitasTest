package org.calculadora.controller;

import org.calculadora.service.impl.CalculatorService;
import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/addNumers")
    public int addNumers(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return calculatorService.addNumers(num1, num2);
    }

    @GetMapping("/subtractNumers")
    public int subtractNumers(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return calculatorService.subtractNumers(num1, num2);
    }
}
