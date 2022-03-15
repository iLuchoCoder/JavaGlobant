package com.mockito.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void bankTransfer_InsufficientFundsException() {
        var testing = new Solution();
        assertEquals("InsufficientFundsException",testing.bankTransfer(1200000.00));

    }

    @Test
    void bankTransfer_InvalidTargetFundsException() {
        var testing = new Solution();
        assertEquals("InvalidTargetFundsException",testing.bankTransfer(900000.00));

    }

    @Test
    void payBill_InsufficientFundsException() {
        var testing = new Solution();
        assertEquals("InsufficientFundsException",testing.payBill(1,1));

    }

    @Test
    void payBill_InvalidBillIdException() {
        var testing = new Solution();
        assertEquals("InvalidBillIdException",testing.payBill(2,1));

    }
}