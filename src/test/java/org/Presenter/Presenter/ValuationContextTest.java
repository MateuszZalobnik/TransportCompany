package org.Presenter.Presenter;

import org.Model.Model.IModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import mockit.*;

class ValuationContextTest {

    @Mocked
    private AutoValuationStrategy mockAutoValuationStrategy;

    @Mocked
    private ManualValuationStrategy mockManualValuationStrategy;

    @Mocked
    private IModel mockModel;

    @Test
    void testWithAutoValuation() {
        GetValuationRequest request = new GetValuationRequest();
        request.IsManualValuation = false;

        ValuationContext context = new ValuationContext(request);
        context.SetStrategy(mockAutoValuationStrategy);

        new Expectations() {{
            mockAutoValuationStrategy.DoAlgorithm(request, mockModel);
            result = 100.0f;
        }};

        float result = context.DoBusinessLogic(request, mockModel);

        assertEquals(100.0f, result, 0.001);

        new Verifications() {{
            mockAutoValuationStrategy.DoAlgorithm(request, mockModel);
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
            mockManualValuationStrategy.DoAlgorithm(request, mockModel);
            result = -1.0f;
        }};

        float result = context.DoBusinessLogic(request, mockModel);

        assertEquals(-1.0f, result, 0.001);

        new Verifications() {{
            mockManualValuationStrategy.DoAlgorithm(request, mockModel);
            times = 1;
        }};
    }
}
