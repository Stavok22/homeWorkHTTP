package homeworkhttp;


import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {

    public static final String URL = "https://http.cat/";


    public String getStatusImage(int code) throws Exception{

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL.concat(code + ".jpg")))
                .headers("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 404) {
            System.out.println("There is not image for HTTP status " + code + "\n");
            throw new HttpStatusCodeException("Error 404: file not found for code: "+code);
        }


        return URL.concat(code + ".jpg");
    }
}

