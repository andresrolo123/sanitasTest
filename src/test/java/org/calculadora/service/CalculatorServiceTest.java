package org.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.corp.calculator.TracerImpl;
import org.calculadora.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

  @Mock
  private TracerImpl tracer;
  
  private CalculatorServiceImpl calculatorService;
  
  @BeforeEach
  void setUp() {
    calculatorService = new CalculatorServiceImpl(tracer);
  }

  @Test
  void shouldAddNumbersSuccessfully() {
    int result = calculatorService.addNumbers(5, 3);
    assertEquals(8, result);
  }

  @Test
  void shouldSubtractNumbersWithoutException() {
    assertDoesNotThrow(() -> {
      calculatorService.subtractNumbers(5, 3);
    });
  }

  @Test
  void shouldThrowExceptionWhenSubtractNumbers() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      calculatorService.subtractNumbers(1, 2);
    });
    assertEquals("Subtraction result cannot be negative", exception.getMessage());
  }
  
  @Test
  void shouldReturnCorrectSubtractionResult() {
    int result = calculatorService.subtractNumbers(10, 3);
    assertEquals(7, result);
  }
}
