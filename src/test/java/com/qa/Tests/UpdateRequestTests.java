package com.qa.Tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import com.qa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class UpdateRequestTests extends BaseTest {

    @Test
    public void updateProducts() {
        //Testing put request with JSON passing as String.
        String json = "{\n" +
                "  \"id\" : 0,\n" +
                "  \"title\" : \"Playwright Testing\",\n" +
                "  \"price\" : 27.99,\n" +
                "  \"description\" : \"A guide to API testing\",\n" +
                "  \"category\" : \"books\",\n" +
                "  \"image\" : \"https://example.com/\"\n" +
                "}";
        String url = "https://fakestoreapi.com/products/21";
        APIResponse apiResponse = requestContext.put(url,
                RequestOptions.create()
                        .setHeader("Accept",
                                "application/json").setData(json));
        Assert.assertTrue(apiResponse.ok());

        System.out.println("Status code is " + apiResponse.status());
        System.out.println("product updated status is  " + apiResponse.statusText());
        String header = apiResponse.headers().get("content-type");
        System.out.println("Header content type is " + header);
        if (apiResponse.headers().get("content-type").contains("application/json")) {
            System.out.println(apiResponse.text());
        } else {
            System.out.println("Still getting HTML! Check the URL.");
        }

    }
}
