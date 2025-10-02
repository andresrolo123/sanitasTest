package org.calculadora.controller;

import jakarta.validation.constraints.NotNull;
import org.calculadora.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
@Validated
public class CalculatorController {
    private static final Logger log = LoggerFactory.getLogger(CalculatorController.class);

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/addNumbers")
    public int addNumbers(@RequestParam("num1") @NotNull Integer num1, 
                         @RequestParam("num2") @NotNull Integer num2) {
        log.info("Received request to add numbers: {} + {}", num1, num2);
        return calculatorService.addNumbers(num1, num2);
    }

    @GetMapping("/subtractNumbers")
    public int subtractNumbers(@RequestParam("num1") @NotNull Integer num1, 
                              @RequestParam("num2") @NotNull Integer num2) {
        log.info("Received request to subtract numbers: {} - {}", num1, num2);
        return calculatorService.subtractNumbers(num1, num2);
    }
}
