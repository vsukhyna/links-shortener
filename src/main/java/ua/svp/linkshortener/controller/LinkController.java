package ua.svp.linkshortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.svp.linkshortener.service.LinkService;

import java.net.URI;

@RestController
@RequestMapping("/links")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping(path = "/generate")
    public String generateShortLink(@RequestParam(name = "link") String userLink) {
        return linkService.generateShortLink(userLink);
    }

    @GetMapping(path = "{link}")
    public ResponseEntity<Void> useShortLink(@PathVariable("link") String shortLink) {
        String userAddress = linkService.useShortLink(shortLink);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(userAddress))
                .build();
    }

}
