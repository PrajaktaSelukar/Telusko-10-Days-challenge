package com.prajakta.ProductSpringWebBitly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class URLService {
    @Autowired
    UrlDb db;
    List<String> urls = new ArrayList<>();
    Random random = new Random();

    public List<URL> getAllUrls() {
        return db.findAll();
    }

    public void addURL(URL url) {
        db.save(url);
    }

    public URL createURLObj(String inputText) {
        String shortUrl = "";  // telusko.ko/abcdef
        List<URL> allData = getAllUrls();
        for(URL url: allData){
            if(url.getInput_url().equals(inputText)){
                url.setOutput_url("https://shortnerApp.com/" +url.getOutput_url()) ;
                return url;
            }
        }

        do{
            shortUrl = generateURL(inputText);
            System.out.println("Created url : " +shortUrl);
            System.out.println(urls.contains(shortUrl));

        }while(urls.contains(shortUrl));

        System.out.println(shortUrl);

        URL obj = new URL(inputText,shortUrl);
        return obj;
    }

    public String generateURL(String inputText) {
        String shortUrl = "";
        //using string builder as we can not append to string directly
        StringBuilder sb = new StringBuilder();
        int index=0;
        sb.setLength(0);
        String[] baseUrl = new String[0];
        String str = inputText;
        if(inputText.contains("/")){
            str = "";
            baseUrl = inputText.split("/");
            for(int i=2; i<baseUrl.length;i++){
                str = str +baseUrl[i];
            }
        }

        String convertedString = str.replaceAll("[^a-zA-Z0-9]", "");
        for(int i=0; i<=6; i++){
            sb.append(convertedString.charAt(random.nextInt(convertedString.length())));
        }
        shortUrl =sb.toString();

        return "https://shortnerApp.com/" + shortUrl;
    }
}
