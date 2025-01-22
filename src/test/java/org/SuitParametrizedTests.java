package org;

import org.Presenter.Presenter.FacadeTest;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(FacadeTest.class)
@IncludeTags("Parametrized")
public class SuitParametrizedTests {
}
