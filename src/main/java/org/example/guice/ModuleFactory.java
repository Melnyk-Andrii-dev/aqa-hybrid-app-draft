package org.example.guice;

import com.google.inject.Module;
import org.testng.IModuleFactory;
import org.testng.ITestContext;

public class ModuleFactory implements IModuleFactory {

    @Override
    public Module createModule(ITestContext iTestContext, Class<?> aClass) {
        return new MainModule(iTestContext.getCurrentXmlTest().getParameter("platformName"));
    }
}
