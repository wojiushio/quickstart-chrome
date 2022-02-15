package org.fluentlenium.examples.pages.zenTao;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

    @PageUrl("https://zentao.citictel-cpc.com/zentao/user-login-L3plbnRhby8=.html")
    public class loginPage extends FluentPage {

        @FindBy(name = "account")
        private FluentWebElement usernameInput;

        @FindBy(name = "password")
        private FluentWebElement passwordInput;

        @FindBy(id = "submit")
        private FluentWebElement loginButton;

        @Override
        public void isAt() {
            await().until(usernameInput).displayed();
        }

        public FluentWebElement getUsernameInput() {
            return usernameInput;
        }



        public FluentWebElement getPasswordInput() {
            return passwordInput;
        }
        public FluentWebElement getloginButton() {
            return loginButton;
        }

        public org.fluentlenium.examples.pages.zenTao.loginPage clearAllTextInputs() {
//            textInputs.clearAllReactInputs();
            return this;
        }
}
