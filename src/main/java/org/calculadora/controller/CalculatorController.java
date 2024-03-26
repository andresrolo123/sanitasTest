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

    @GetMapping("/addNumbers")
    public int addNumbers(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return calculatorService.addNumbers(num1, num2);
    }

    @GetMapping("/subtractNumbers")
    public int subtractNumbers(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return calculatorService.subtractNumbers(num1, num2);
    }
}
