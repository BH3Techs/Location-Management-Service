package com.example.locationmanagementservice.service;

import com.example.locationmanagementservice.messages.BaseResponse;
import com.example.locationmanagementservice.model.Shop;
import com.example.locationmanagementservice.model.ShopDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 5/7/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * LocationManagementService
 **/
public interface ShopService {
    public List<ShopDetails> findAll();

    public ResponseEntity<Object> addShop(ShopDetails customerDetails);

    public ShopDetails findByShopNumber(Long customerNumber);
}
