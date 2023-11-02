package ua.svp.linkshortener.service;

public interface LinkService {

    String generateShortLink(String userLink);

    String useShortLink(String shortLink);

    void clearAll();

}
