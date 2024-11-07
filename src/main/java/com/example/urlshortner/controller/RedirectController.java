package com.example.urlshortner.controller;

import com.example.urlshortner.entity.Redirect;
import com.example.urlshortner.request.RedirectCreationRequest;
import com.example.urlshortner.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.http.HttpStatus.MOVED_PERMANENTLY;

@RestController
public class RedirectController {

    private final RedirectService redirectService;

    @Autowired
    public RedirectController(RedirectService redirectService) {
        this.redirectService = redirectService;
    }

    @GetMapping("/{alias}")
    public ResponseEntity<?> handleRedirect(@PathVariable String alias) throws URISyntaxException {
        Redirect redirect = redirectService.getRedirect(alias);
        System.out.println("We're redirecting here!" + redirect);
        URI uri = new URI(redirect.getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, MOVED_PERMANENTLY);
    }

    @PostMapping("/")
    public ResponseEntity<?> createRedirect(@Validated @RequestBody RedirectCreationRequest redirectCreationRequest) {
        return ResponseEntity.ok(redirectService.createRedirect(redirectCreationRequest));
    }
}
