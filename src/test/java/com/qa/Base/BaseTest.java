package com.qa.Base;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    Playwright playwright;
    APIRequest apiRequest;
    protected APIRequestContext requestContext;

    @BeforeTest
    public void setup() {
        playwright = Playwright.create();
        apiRequest = playwright.request();
        requestContext = apiRequest.newContext();
    }
    @AfterTest
    public void tearDown() {
        playwright.close();
    }

}
