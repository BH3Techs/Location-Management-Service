package com.example.locationmanagementservice.controller;

import com.example.locationmanagementservice.messages.BaseResponse;
import com.example.locationmanagementservice.model.Shop;
import com.example.locationmanagementservice.service.ShopService;
import com.example.locationmanagementservice.shopRepo.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 5/7/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * LocationManagementService
 **/

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    private ShopRepo shopRepo;

    //This method will be used to create or update any record in the shop
    @PostMapping(value = { "/add", "/update" })
    public ResponseEntity<BaseResponse> createOrUpdateShop(@Valid @RequestBody Shop shop) {
        BaseResponse response = shopService.createOrUpdateShop(shop);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/allShops")
    public List<Shop> findAllShops() {
        return (List<Shop>) shopRepo.findAll();
    }
}
