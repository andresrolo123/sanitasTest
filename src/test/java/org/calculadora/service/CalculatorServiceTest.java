package org.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

class CalculatorServiceTest {

  @Mock
  private final TracerImpl tracer = new TracerImpl();
  @Autowired
  private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl(tracer);

  @Test
  void shouldAddNumbers() {
    assertDoesNotThrow(() -> {
      calculatorService.subtractNumbers(1, 1);
    });
  }

  @Test
  void shouldThrowExceptionWhenSubtractNumbers() {
    assertThrows(IllegalArgumentException.class, () -> {
      calculatorService.subtractNumbers(1, 2);
    });
  }
}
