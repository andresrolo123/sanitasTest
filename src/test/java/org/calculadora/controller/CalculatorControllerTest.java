package org.calculadora.controller;

import org.calculadora.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CalculatorController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorControllerTest {

  @MockBean
  private CalculatorServiceImpl calculatorService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void shouldAddNumbers() throws Exception {
    
    Mockito.when(calculatorService.addNumbers(1, 2)).thenReturn(3);
    
    mockMvc.perform(MockMvcRequestBuilders.get("/api/calculator/addNumbers?num1=1&num2=2"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("3"));

    Mockito.verify(calculatorService, Mockito.times(1)).addNumbers(1, 2);
    
  }

  @Test
  void shouldSubtractNumbers() throws Exception {
      
      Mockito.when(calculatorService.subtractNumbers(2, 1)).thenReturn(1);
      
      mockMvc.perform(MockMvcRequestBuilders.get("/api/calculator/subtractNumbers?num1=2&num2=1"))
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.content().string("1"));
  
      Mockito.verify(calculatorService, Mockito.times(1)).subtractNumbers(2, 1);
  }

}
