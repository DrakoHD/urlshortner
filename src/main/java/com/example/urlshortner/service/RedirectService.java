package com.example.urlshortner.service;

import com.example.urlshortner.entity.Redirect;
import com.example.urlshortner.exception.BadRequestException;
import com.example.urlshortner.exception.NotFoundException;
import com.example.urlshortner.repository.RedirectRepository;
import com.example.urlshortner.request.RedirectCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectService {

    private final RedirectRepository redirectRepository;

    @Autowired
    public RedirectService(RedirectRepository redirectRepository) {
        this.redirectRepository = redirectRepository;
    }

    public Optional<Redirect> createRedirect(RedirectCreationRequest redirectCreationRequest) {
        if (redirectRepository.existsByAlias(redirectCreationRequest.getAlias())) {
            throw new BadRequestException("Alias already exists");
        }
        System.out.println("Redirect Request " + redirectCreationRequest.toString());
        Redirect redirect = new Redirect(redirectCreationRequest.getAlias(), redirectCreationRequest.getUrl());

        Redirect postSaveRedirect = redirectRepository.save(redirect);
        System.out.println("Redirect" + postSaveRedirect);

        return Optional.of(postSaveRedirect);
    }

    public Redirect getRedirect(String alias) {
        return redirectRepository.findByAlias(alias)
                .orElseThrow(() -> new NotFoundException("Hey we don't have that alias ! Try making it"));
    }
}
