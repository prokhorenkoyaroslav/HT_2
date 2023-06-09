package com.example.ht_2.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class PMain {

    private static final SelenideElement SEARCH_BUTTON          = $x("//button[@placeholder='Search or jump to...']");

    private static final SelenideElement SEARCH_FIELD           = $("#query-builder-test");

    private static final ElementsCollection REPOSITORIES        = $$x("//div[@data-testid='results-list']");

    private static final String REPOSITORY_LINK                 = ".//*[@href='/%s']";


    public PRepository searchRepository(String repoName) {
        SEARCH_BUTTON.click();
        SEARCH_FIELD.setValue(repoName).pressEnter();
        var searchedRepository = REPOSITORIES.first();
        searchedRepository.$x(String.format(REPOSITORY_LINK, repoName)).click();
        return new PRepository();
    }
}
