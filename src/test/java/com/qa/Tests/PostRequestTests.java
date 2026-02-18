package com.qa.Tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import com.qa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PostRequestTests extends BaseTest {
    @Test
    public void addProducts() {
        Map<String, Object> data = createData();
        String url = "https://fakestoreapi.com/products";
        APIResponse apiResponse = requestContext.post(url,
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
    public Map<String, Object> createData(){
        Map<String, Object> data = new HashMap<>();
        data.put("id",0);
        data.put("title", "Playwright Testing");
        data.put("price", 25.99);
        data.put("description", "A guide to API testing");
        data.put("category", "books");
        data.put("image", "https://example.com/");

        return data;
    }

}
