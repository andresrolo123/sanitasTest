package org.calculadora.service.impl;

import io.corp.calculator.TracerImpl;
import org.calculadora.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private static final Logger log = LoggerFactory.getLogger(CalculatorServiceImpl.class);
    private final TracerImpl tracer;

    public CalculatorServiceImpl(TracerImpl tracer) {
        this.tracer = tracer;
    }

    @Override
    public int addNumbers(int num1, int num2) {
        log.debug("Adding numbers: {} + {}", num1, num2);
        int total = num1 + num2;
        log.info("Addition result: {}", total);
        tracer.trace(total);
        return total;
    }
    
    @Override
    public int subtractNumbers(int num1, int num2) {
        log.debug("Subtracting numbers: {} - {}", num1, num2);
        int total = num1 - num2;
        if (total < 0) {
            log.warn("Subtraction would result in negative number: {} - {} = {}", num1, num2, total);
            throw new IllegalArgumentException("Subtraction result cannot be negative");
        }
        log.info("Subtraction result: {}", total);
        tracer.trace(total);
        return total;
    }
    
}
