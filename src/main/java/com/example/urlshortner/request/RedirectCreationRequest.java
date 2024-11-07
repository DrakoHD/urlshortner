package com.example.urlshortner.request;

import lombok.Getter;

public class RedirectCreationRequest {

    @Getter
    private String alias;

    @Getter
    private String url;

    public RedirectCreationRequest(final String alias, final String url) {
        this.alias = alias;
        this.url = url;
    }

    @Override
    public String toString() {
        return "RedirectCreationRequest{" +
                "alias='" + alias + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
