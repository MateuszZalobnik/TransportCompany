package org.Presenter.Presenter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import mockit.*;

class ValuationContextTest {

    @Mocked
    private AutoValuationStrategy mockAutoValuationStrategy;

    @Mocked
    private ManualValuationStrategy mockManualValuationStrategy;

    @Test
    void testWithAutoValuation() {
        GetValuationRequest request = new GetValuationRequest();
        request.IsManualValuation = false;

        ValuationContext context = new ValuationContext(request);
        context.SetStrategy(mockAutoValuationStrategy);

        new Expectations() {{
            mockAutoValuationStrategy.DoAlgorithm(request);
            result = 100.0f;
        }};

        float result = context.DoBusinessLogic(request);

        assertEquals(100.0f, result, 0.001);

        new Verifications() {{
            mockAutoValuationStrategy.DoAlgorithm(request);
            times = 1;
        }};
    }

    @Test
    void testWithManualValuation() {
        GetValuationRequest request = new GetValuationRequest();
        request.IsManualValuation = true;

        ValuationContext context = new ValuationContext(request);
        context.SetStrategy(mockManualValuationStrategy);

        new Expectations() {{
            mockManualValuationStrategy.DoAlgorithm(request);
            result = -1.0f;
        }};

        float result = context.DoBusinessLogic(request);

        assertEquals(-1.0f, result, 0.001);

        new Verifications() {{
            mockManualValuationStrategy.DoAlgorithm(request);
            times = 1;
        }};
    }
}
