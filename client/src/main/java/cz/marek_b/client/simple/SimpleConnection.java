package cz.marek_b.client.simple;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleConnection {
    
    private static final String BASE_URL = "http://localhost:8080/server";

    public void sendGet() throws IOException {
        String urlStr = BASE_URL + "/hello/simple";
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        
        int responseCode = con.getResponseCode();
        System.out.println("response: " + responseCode);
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            System.out.println("response data: " + response.toString());
        } catch (IOException e) {
            throw e;
        }
    }
    
    public void sendPost() throws Exception {
        String urlStr = BASE_URL + "/hello/simple";
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        
        String urlParams = "param1=testParam1&param2=testParam2";
        
        try (DataOutputStream dos = new DataOutputStream(con.getOutputStream())) {
            dos.writeBytes(urlParams);
            dos.flush();
        }
        
        int responseCode = con.getResponseCode();
        System.out.println("Response: " + responseCode);
        
        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }
        
        System.out.println("Response data: " + response);
    }
    
}
