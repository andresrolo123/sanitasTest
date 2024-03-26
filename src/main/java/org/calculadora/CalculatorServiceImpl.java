package org.calculadora;

import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl {
    private final TracerImpl tracer;

    public CalculatorServiceImpl(TracerImpl tracer) {
        this.tracer = tracer;
        tracer.trace(2);
    }
    
}
