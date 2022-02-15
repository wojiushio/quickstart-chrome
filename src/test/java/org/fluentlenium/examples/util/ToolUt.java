package org.fluentlenium.examples.util;
import io.qameta.allure.*;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.TestListenerAdapter;

public class ToolUt extends TestListenerAdapter {

    @Attachment(value = "{0},截图", type = "image/png")
    public static byte[] takeScreenShot(String methodName, TakesScreenshot drivername) {

        return drivername.getScreenshotAs(OutputType.BYTES);
    }
}


