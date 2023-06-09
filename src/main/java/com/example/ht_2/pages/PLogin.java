package com.example.ht_2.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.ht_2.config.ApplicationConfig;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PLogin {

    private static final SelenideElement LOGIN_FIELD    = $("#login_field");
    private static final SelenideElement PASSWORD_FIELD = $("#password");
    private static final SelenideElement SUBMIT_LOGIN   = $("[name='commit']");


    private static final String USERNAME = System.getenv("USERNAME");
    private static final String PASSWORD = System.getenv("PASSWORD");


    public PMain loginUser() {
        open(ApplicationConfig.mainUrl);

        $(LOGIN_FIELD).setValue(USERNAME);
        $(PASSWORD_FIELD).setValue(PASSWORD);

        $(SUBMIT_LOGIN).click();

        return new PMain();
    }
}
