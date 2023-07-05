package com.example.locationmanagementservice.service.impl;

import com.example.locationmanagementservice.exception.CustomDataIntegrityViolationException;
import com.example.locationmanagementservice.messages.*;
import com.example.locationmanagementservice.model.Shop;
import com.example.locationmanagementservice.service.ShopService;
import com.example.locationmanagementservice.shopRepo.ShopRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * 5/7/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * LocationManagementService
 **/
@Service
@Slf4j
public class ShopServiceImpl implements ShopService {

    private ShopRepo shopRepo;
    @Override
    public BaseResponse createOrUpdateShop(Shop shop) {
        try {
            log.info("RECEIVED SHOP INFO "+shop.toString());
            shopRepo.save(shop);
        }  catch (DataIntegrityViolationException ex) {
            throw new CustomDataIntegrityViolationException(ex.getCause().getCause().getMessage());
        }
        return new BaseResponse(shopRepo.findShopByShopID(Long.valueOf(shop.getShopID())) + CustomMessage.SAVE_SUCCESS_MESSAGE);
    }
}
