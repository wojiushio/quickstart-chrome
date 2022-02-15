package org.fluentlenium.examples.test.zenTao;

import io.qameta.allure.*;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.examples.pages.zenTao.loginPage;
import org.fluentlenium.examples.test.AbstractChromeNgTest;
import org.fluentlenium.examples.test.AbstractChromeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

//@Listeners({TestFailListener.class})
@Epic("Epic示例")
@Feature("testNG+allure集成")
public class LoginPageNgTest extends AbstractChromeNgTest {

    @Page
    private loginPage loginPage;

//    @BeforeClass
    public void setUp() {
        goTo(loginPage).isAt();
    }

    @Test(priority = 1, description = "测试账号正常登录和退出")
    @Step("的角度讲")
    @Issue("AG-2759823")
    @Feature("登陆退出")
    @Story("登陆退出")
    @Description("Description注解：验证主页测试1")
    @Epic("freya")
    @Link(name = "https://blog.csdn.net/fen_fen/article/details/120580047",value ="ss")
    @Severity(SeverityLevel.TRIVIAL)
    public void shouldLogin() {
        goTo(loginPage);
        enterKey(loginPage,loginPage.getUsernameInput(),"op1911");
        enterKey(loginPage,loginPage.getPasswordInput(),"6281621dYx!");

        click(loginPage,loginPage.getloginButton());
//        loginPage.getUsernameInput().fill().with("op1911");
//        loginPage.getPasswordInput().fill().with("6281621dYx!");
//        loginPage.getloginButton().click();
//        loginPage.takeScreenshot();
        System.out.println(loginPage.getScreenshotPath());
        assertThat(window().title()).contains("FluentLenium");

    }


    @Test
    public void verifyPageAssertions() {
        assertThat(loginPage).hasTitle("MobX React Form");
        assertThat(loginPage).hasPageSourceContaining("light-red");
        assertThat(loginPage).hasElements($("button"));
        assertThat(loginPage).hasElement(el("[name=email]"));
        assertThat(loginPage).hasElementDisplayed(el("[name=email]"));
        assertThat(loginPage).hasExpectedElements();
        assertThat(loginPage).hasExpectedUrl();
        assertThat(loginPage).hasUrl("https://foxhound87.github.io/mobx-react-form-demo/demo");
    }
}
