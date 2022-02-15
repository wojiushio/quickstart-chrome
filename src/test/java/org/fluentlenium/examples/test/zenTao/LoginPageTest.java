package org.fluentlenium.examples.test.zenTao;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.examples.pages.zenTao.loginPage;
import org.fluentlenium.examples.test.AbstractChromeTest;
import org.junit.Before;
import org.junit.Test;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;


    public class LoginPageTest extends AbstractChromeTest {

        @Page
        private loginPage loginPage;

        @Before
        public void setUp() {
            goTo(loginPage).isAt();
        }
        @Test
        public void shouldLogin() {
            loginPage.getUsernameInput().fill().with("op1911");
            loginPage.getPasswordInput().fill().with("6281621dYx!");
            loginPage.getloginButton().click();
            loginPage.takeScreenshot();
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
