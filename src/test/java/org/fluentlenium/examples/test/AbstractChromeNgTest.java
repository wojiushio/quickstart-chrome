package org.fluentlenium.examples.test;

import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.fluentlenium.adapter.testng.FluentTestNg;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.examples.util.ToolUt;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.os.ExecutableFinder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public abstract class AbstractChromeNgTest extends FluentTestNg {

    private static final String PATH_TO_CHROME_DRIVER = "C:\\drivers\\chromedriver.exe";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    @BeforeClass
    public static void setup() {
        if (systemPropertyNotSet() && executableNotPresentInPath()) {
            setSystemProperty();
        }
    }


    private static boolean executableNotPresentInPath() {
        return new ExecutableFinder().find("chromedriver") == null;
    }

    private static boolean systemPropertyNotSet() {
        return System.getProperty(CHROME_DRIVER_PROPERTY) == null;
    }

    private static void setSystemProperty() {
        System.setProperty(CHROME_DRIVER_PROPERTY, PATH_TO_CHROME_DRIVER);
    }

    /*
     * 以下是steps
     */
    @Step("点击输入框:{1},然后输入 {2} 。")
    @Link("https://zentao.citictel-cpc.com/zentao/my-bug-assignedTo.html")

    public void enterKey(FluentPage fluentPage, FluentWebElement by, String key) {

//        try {

        by.fill().with(key);


//            driver.hideKeyboard();
//            ToolUt.takeScreenShot("输入:"+key, driver);

//            fluentPage.takeScreenshot();
        ToolUt.takeScreenShot("输入"+ key, (TakesScreenshot) fluentPage.getDriver());
//        } catch (Exception e) {
//            e.printStackTrace();
//            ToolUt.takeScreenShot(e.toString(), driver);
//			Assert.assertEquals(true, false, e.toString());
//            Assert.fail("输入失败，找不到元素"+by);


    }

    @Step("点击控件:{1} 。")
    public void click(FluentPage fluentPage, FluentWebElement by) {
        try {
            by.click();
            ToolUt.takeScreenShot("点击控件::" + by, (TakesScreenshot) fluentPage.getDriver());
        } catch (Exception e) {
            e.printStackTrace();
            ToolUt.takeScreenShot("ddfffff", (TakesScreenshot) fluentPage.getDriver());
            Assert.fail("点击失败，找不到元素" + by);

        }

    }
}
