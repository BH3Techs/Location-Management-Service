package com.example.locationmanagementservice.service;

import com.example.locationmanagementservice.messages.BaseResponse;
import com.example.locationmanagementservice.model.Shop;

/**
 * 5/7/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * LocationManagementService
 **/
public interface ShopService {
    BaseResponse createOrUpdateShop(Shop shop);
}
