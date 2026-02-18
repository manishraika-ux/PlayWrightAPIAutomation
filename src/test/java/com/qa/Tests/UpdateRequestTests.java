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
        Map<String, Object> data = createData();
        String url = "https://fakestoreapi.com/products/21";
        APIResponse apiResponse = requestContext.put(url,
                RequestOptions.create()
                        .setHeader("Accept",
                                "application/json").setData(data));
        Assert.assertTrue(apiResponse.ok());

        System.out.println("Status code is " + apiResponse.status());
        System.out.println("Status Text is " + apiResponse.statusText());
        String header = apiResponse.headers().get("content-type");
        System.out.println("Header content type is " + header);
        if (apiResponse.headers().get("content-type").contains("application/json")) {
            System.out.println(apiResponse.text());
        } else {
            System.out.println("Still getting HTML! Check the URL.");
        }

    }

    public Map<String, Object> createData() {
        Map<String, Object> data = new HashMap<>();
        data.put("id", 0);
        data.put("title", "Playwright Testing");
        data.put("price", 27.99);
        data.put("description", "A guide to API testing");
        data.put("category", "books");
        data.put("image", "https://example.com/");

        return data;
    }
}
