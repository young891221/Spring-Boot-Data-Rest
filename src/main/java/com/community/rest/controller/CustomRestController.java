package com.community.rest.controller;

import com.community.rest.domain.Store;
import com.community.rest.repository.StoreRepository;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
public class CustomRestController {

    private StoreRepository storeRepository;

    public CustomRestController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    //url 규칙이 맞아야 리퀘스트가 들어옴
    @GetMapping("/stores/search/addTest")
    public @ResponseBody ResponseEntity<?> basicTest() {
        List<Store> storeList = storeRepository.findAll();
        storeList.add(Store.builder().name("Test Store").location("Guri").build());

        Resources<Store> resources = new Resources<>(storeList);
        resources.add(linkTo(methodOn(CustomRestController.class).basicTest()).withSelfRel());
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/stores/search/test")
    public @ResponseBody Resources<Store> basicTestReturnStore() {
        List<Store> storeList = storeRepository.findAll();
        storeList.add(Store.builder().name("Test Store2").location("Guri2").build());

        Resources<Store> resources = new Resources<>(storeList);
        resources.add(linkTo(methodOn(CustomRestController.class).basicTestReturnStore()).withSelfRel());
        return resources;
    }
}
