package com.encora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.encora.CheckBalancedParenthesis.isBalanceado;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckBalancedParenthesisTest {


    @BeforeEach
    void setUp() {
    }

    @Test
    public void testParentesisBienBalanceado() {
        assertTrue(isBalanceado("()"));
    }

    @Test
    public void testParentesisMalBalanceado() {
        assertFalse(isBalanceado("(()"));
    }

    @Test
    public void testParentesisLlavesBienBalanceado() {
        assertTrue(isBalanceado("({})"));
    }

    @Test
    public void testParentesisLlavesMalBalanceado() {
        assertFalse(isBalanceado("({)}"));
    }

    @Test
    public void testParentesisInvertidoMalBalanceado() {
        assertFalse(isBalanceado(")("));
    }

    @Test
    public void testCombinacionCompleja() {
        assertTrue(isBalanceado("[{[]}()]"));
    }

    @Test
    public void testLlavesParentesisBienBalanceado() {
        assertTrue(isBalanceado("{}()"));
    }

    @Test
    public void testLlavesSolasBienBalanceado() {
        assertTrue(isBalanceado("{}"));
    }

}
