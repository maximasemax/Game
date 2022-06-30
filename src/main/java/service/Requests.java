package service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requests {

    URL urlForAnimal = new URL("https://random-word-form.herokuapp.com/random/animal");
    URL urlForAdjective = new URL("https://random-word-form.herokuapp.com/random/adjective");

    public Requests() throws MalformedURLException {
    }

    private HttpResponse<String> response(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(url)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    private String requestsRandomAnimal() throws IOException, InterruptedException {
        String animal = response(String.valueOf(urlForAnimal)).body();
        char[] rezult = animal.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i < rezult.length-2; i++)
            stringBuilder.append(rezult[i]);
        return stringBuilder.toString();
    }

    private String requestsRandomAdjective() throws IOException, InterruptedException {
        String animal = response(String.valueOf(urlForAdjective)).body();
        char[] rezult = animal.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i < rezult.length-2; i++)
            stringBuilder.append(rezult[i]);
        return stringBuilder.toString();
    }

    public String mix() throws IOException, InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(requestsRandomAdjective());
        stringBuilder.append(" ");
        stringBuilder.append(requestsRandomAnimal());
        return stringBuilder.toString();
    }

}
