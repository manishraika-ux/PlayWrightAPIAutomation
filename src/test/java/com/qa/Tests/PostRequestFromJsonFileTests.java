package com.qa.Tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import com.qa.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class PostRequestFromJsonFileTests extends BaseTest {
    @Test
    public void addProducts() throws IOException {
        byte[] fileBytes = getJsonFile();
        String url = "https://fakestoreapi.com/products";
        APIResponse apiResponse = requestContext.post(url,
                RequestOptions.create()
                        .setHeader("Accept",
                                "application/json").setData(fileBytes));
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

    public byte[] getJsonFile() throws IOException {
        File file = new File("./src/test/data/user.json");
        return Files.readAllBytes(file.toPath());
    }

}
