package com.example.ht_2.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PRepository {

    private static final String FILE_NAME_LABEL = "//a[.='%s']";

    private static final SelenideElement FILE_CONTENT_TEXTAREA = $("#read-only-cursor-text-area");

    public PRepository openFile(String name) {
        $x(String.format(FILE_NAME_LABEL, name)).click();
        Selenide.sleep(5000);
        return this;
    }

    public SelenideElement getContent() {
        return FILE_CONTENT_TEXTAREA;
    }


}
