package org.Presenter.Presenter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ValuationContextTest {

    @Test
    void testConstructorWithAutoValuation() {
        GetValuationRequest request = new GetValuationRequest();
        request.IsManualValuation = false;

        IValuationStrategy mockStrategy = mock(AutoValuationStrategy.class);

        ValuationContext context = new ValuationContext(request);
        context.SetStrategy(mockStrategy);

        when(mockStrategy.DoAlgorithm(request)).thenReturn(100.0f);

        float result = context.DoBusinessLogic(request);

        assertEquals(100.0f, result, 0.001);
        verify(mockStrategy, times(1)).DoAlgorithm(request);
    }

    @Test
    void testConstructorWithManualValuation() {
        GetValuationRequest request = new GetValuationRequest();
        request.IsManualValuation = true;

        IValuationStrategy mockStrategy = mock(ManualValuationStrategy.class);

        ValuationContext context = new ValuationContext(request);

        context.SetStrategy(mockStrategy);

        when(mockStrategy.DoAlgorithm(request)).thenReturn(-1.0f);

        float result = context.DoBusinessLogic(request);

        assertEquals(-1.0f, result, 0.001);
        verify(mockStrategy, times(1)).DoAlgorithm(request);
    }
}