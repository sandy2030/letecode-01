package com.interview;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UrlMappingService {

    private final HashMap<String, String> urlMap = new HashMap<>();  // Map short URL -> original URL
    private final HashMap<String, String> reverseMap = new HashMap<>();  // Map original URL -> short URL
    private final static AtomicLong idCounter = new AtomicLong(1);  // Unique ID generator
    static int q=1;
    private final ShortUrlGenerator urlGenerator = new ShortUrlGenerator();

    // Shorten the given URL
    public String shortenUrl(String originalUrl) {
        if (reverseMap.containsKey(originalUrl)) {
            return reverseMap.get(originalUrl);
        }

        long id = idCounter.getAndIncrement();
        System.out.println("q: "+q);
        q++;
        String shortUrl = urlGenerator.encode(id);
        urlMap.put(shortUrl, originalUrl);
        reverseMap.put(originalUrl, shortUrl);
        return shortUrl;
    }

    // Get the original URL from a shortened URL
    public String getOriginalUrl(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    public static void main(String[] args) {
        UrlMappingService service=new UrlMappingService();
        System.out.println(service.shortenUrl("ssasafwewewewewewewewewe.co.in"));
    }
}
