package org.Presenter.Presenter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    void testDoBusinessLogic() {
        // Arrange
        IValuationStrategy mockStrategy = mock(IValuationStrategy.class);
        ValuationContext context = new ValuationContext(new GetValuationRequest());
        context.SetStrategy(mockStrategy);

        GetValuationRequest request = new GetValuationRequest();
//        when(mockStrategy.DoAlgorithm(request)).thenReturn(42.0f);

        // Act
        float result = context.DoBusinessLogic(request);

        // Assert
//        assertEquals(42.0f, result);
//        verify(mockStrategy, times(1)).DoAlgorithm(request);
    }


}