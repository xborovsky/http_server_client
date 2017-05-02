package cz.marek_b.client.apache;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class SimpleApacheHttpClient {

    private static final String BASE_URL = "http://localhost:8080/server";
    
    public void sendGet() throws Exception {
        String url = BASE_URL + "/hello/simple";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet(url);
        
        HttpResponse response = httpClient.execute(getRequest);
        
        System.out.println("response code: " + response.getStatusLine().getStatusCode());
        
        StringBuilder responseData = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                responseData.append(inputLine);
            }
        }
        
        System.out.println("response data: " + responseData);
    }
    
    public void sendPost() throws Exception {
        String url = BASE_URL + "/hello/simple";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("param1", "testParam1"));
        params.add(new BasicNameValuePair("param2", "testParam2"));
        post.setEntity(new UrlEncodedFormEntity(params));
        
        HttpResponse response = httpClient.execute(post);
        
        int responseCode = response.getStatusLine().getStatusCode();
        System.out.println("Response code: " + responseCode);
        
        StringBuilder responseData = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
            String inputLine;
            while((inputLine = in.readLine()) != null) {
                responseData.append(inputLine);
            }
        }
        System.out.println("response data: " + responseData);
    }
    
}
