package org.calculadora.service;

import io.corp.calculator.TracerImpl;
import org.calculadora.service.impl.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private final TracerImpl tracer;

    public CalculatorServiceImpl(TracerImpl tracer) {
        this.tracer = tracer;
    }

    @Override
    public int addNumbers(int num1, int num2) {
        int total = num1 + num2;
        tracer.trace(total);
        return total;
    }
    
    @Override
    public int subtractNumbers(int num1, int num2) {
        int total = num1 - num2;
        if (total < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        tracer.trace(total);
        return total;
    }
    
}
