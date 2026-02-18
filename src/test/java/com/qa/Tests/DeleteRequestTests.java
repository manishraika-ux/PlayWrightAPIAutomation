package com.qa.Tests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import com.qa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteRequestTests extends BaseTest {
    @Test
    public void deleteProducts() {

        String url = "https://fakestoreapi.com/products/21";
        APIResponse apiResponse = requestContext.delete(url, RequestOptions.create().setHeader("Accept",
                "application/json"));
        Assert.assertTrue(apiResponse.ok());

        System.out.println("Status code is " + apiResponse.status());
        System.out.println("product deleted status  " + apiResponse.statusText());
        String header = apiResponse.headers().get("content-type");
        System.out.println("Header content type is " + header);
        if (apiResponse.headers().get("content-type").contains("application/json")) {
            System.out.println(apiResponse.text());
        } else {
            System.out.println("Still getting HTML! Check the URL.");
        }

    }

}
