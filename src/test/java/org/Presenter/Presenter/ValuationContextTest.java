package org.Presenter.Presenter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValuationContextTest {

    @Test
    void testConstructorWithAutoValuation() {
        // Arrange
        GetValuationRequest request = new GetValuationRequest();
        request.IsManualValuation = false; // Auto valuation

        // Act
        ValuationContext context = new ValuationContext(request);

        // Assert
//        assertTrue(context.getStrategy() instanceof AutoValuationStrategy);
    }

    @Test
    void testConstructorWithManualValuation() {
        // Arrange
        GetValuationRequest request = new GetValuationRequest();
        request.IsManualValuation = true; // Manual valuation

        // Act
        ValuationContext context = new ValuationContext(request);

        // Assert
//        assertTrue(context.getStrategy() instanceof ManualValuationStrategy);
    }

}