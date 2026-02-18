package com.qa.Tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import com.qa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PostRequestTestsFromPojoTests extends BaseTest {
    @Test
    public void addProducts() throws JsonProcessingException {
        Map<String, Object> data = createData();
        String url = "https://fakestoreapi.com/products";
        APIResponse apiResponse = requestContext.post(url,
                RequestOptions.create()
                        .setHeader("Accept",
                                "application/json").setData(data));
        Assert.assertTrue(apiResponse.ok());

        System.out.println("Status code is " + apiResponse.status());
        System.out.println("Product is  " + apiResponse.statusText());
        String header = apiResponse.headers().get("content-type");
        System.out.println("Header content type is " + header);
        String response = apiResponse.text();
        System.out.println(response);
        // extracting data from response
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(response);
        int id = json.get("id").asInt();
        Assert.assertEquals(id, 21);
        String title = json.get("title").asText();
        Assert.assertEquals(title, "Playwright Testing");
    }

    public Map<String, Object> createData() {
        Map<String, Object> data = new HashMap<>();
        data.put("id", 0);
        data.put("title", "Playwright Testing");
        data.put("price", 25.99);
        data.put("description", "A guide to API testing");
        data.put("category", "books");
        data.put("image", "https://example.com/");

        return data;
    }

}
