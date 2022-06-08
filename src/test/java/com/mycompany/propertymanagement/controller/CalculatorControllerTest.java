package com.mycompany.propertymanagement.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
    @InjectMocks
    private CalculatorController calculatorController;
    static Double num1;
    static Double num2;
    static Double num3;

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
        num1 = 3.5;
        num2 = 3.5;
        num3 = 3.5;
    }

    @BeforeEach
    void init() {
        System.out.println("Before Each");

    }

    @AfterEach
    void destroy() {
        System.out.println("After Each");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("After All");
        num1 = null;
        num2 = null;
        num3 = null;
    }

    @Test
    @DisplayName("Test Addition Success senario")
    void testAddFunction_Success() {
        Double result = calculatorController.add(num1, num2, num3);
        //Expected is 7.0
        //Always perform assestion
        //if its not take expected simply type 7.0,result its take automatically
        Assertions.assertEquals(7.0, result);


    }

    @Test
   // @Disabled
    @DisplayName("Test Addition failure senario")
    void testAddFunction_Failure() {
        Double result = calculatorController.add(3.5, 3.5, 3.5);
        //Expected is 7.0
        //Always perform assestion
        Assertions.assertNotEquals(7.0, result);

    }

    @Test
    @DisplayName("Test sub success num1>num2 senario")
    public void testSubFunction_num1_It_num2() {
        Double result = calculatorController.substract(num1 , num2+1);
        Assertions.assertEquals(1.0, result);
    }

    @Test
    @DisplayName("Test sub success num1>num2 senario")
    public void testSubFunction_num1_gt_num2() {
        Double result = calculatorController.substract(num1+1, num2 );
        Assertions.assertEquals(1.0, result);
    }

}