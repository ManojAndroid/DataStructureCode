/*
package com.learning.design.UrlShortining;

@RestController
@RequestMapping("/api/url")
public class URLShortenerController {

    private final URLShortenerService urlShortenerService;

    @Autowired
    public URLShortenerController(URLShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenURL(@RequestBody String longURL) {
        String shortURL = urlShortenerService.shortenURL(longURL);
        return ResponseEntity.ok(shortURL);
    }


    @GetMapping("/expand/{shortURL}")
    public ResponseEntity<String> expandURL(@PathVariable String shortURL) {
        String longURL = urlShortenerService.expandURL(shortURL);
        return ResponseEntity.ok(longURL);
    }
}*/
