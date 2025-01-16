package br.com.alura.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsume {
    public String getData(String bookTitle){
        String url = "https://gutendex.com/books/?search=" + bookTitle;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = null;
        try {
             response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } 
        String json = response.body();
        return json;
    }
}
