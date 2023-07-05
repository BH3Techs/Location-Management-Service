package com.example.locationmanagementservice.service.impl;

import com.example.locationmanagementservice.model.Shop;
import com.example.locationmanagementservice.model.ShopDetails;
import com.example.locationmanagementservice.service.ShopService;
import com.example.locationmanagementservice.service.helper.ShopServiceHelper;
import com.example.locationmanagementservice.shopRepo.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 5/7/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * LocationManagementService
 **/
@Service
@Slf4j
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ShopServiceHelper shopServiceHelper;

    public ShopServiceImpl(ShopRepository repository) {
        this.shopRepository =repository;
    }


    public List<ShopDetails> findAll() {

        List<ShopDetails> allShopDetails = new ArrayList<>();

        Iterable<Shop> customerList = shopRepository.findAll();

        customerList.forEach(customer -> {
            allShopDetails.add(shopServiceHelper.convertToShopDomain(customer));
        });

        return allShopDetails;
    }
    /**
     * CREATE Shop
     *
     * @param customerDetails
     * @return
     */
    public ResponseEntity<Object> addShop(ShopDetails customerDetails) {

        Shop customer = shopServiceHelper.convertToShopEntity(customerDetails);
        shopRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body("New Shop created successfully.");
    }

    /**
     * READ Shop
     *
     * @param shopID
     * @return
     */

    public ShopDetails findByShopNumber(Long shopID) {

        Optional<Shop> customerEntityOpt = shopRepository.findByShopID(shopID);

        if(customerEntityOpt.isPresent())
            return shopServiceHelper.convertToShopDomain(customerEntityOpt.get());

        return null;
    }

    /**
     * DELETE Shop
     *
     * @param customerNumber
     * @return
     */
    public ResponseEntity<Object> deleteShop(Long customerNumber) {

        Optional<Shop> managedShopEntityOpt = shopRepository.findByShopID(customerNumber);

        if(managedShopEntityOpt.isPresent()) {
            Shop managedShopEntity = managedShopEntityOpt.get();
            shopRepository.delete(managedShopEntity);
            return ResponseEntity.status(HttpStatus.OK).body("Success: Shop deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Shop does not exist.");
        }

        //TODO: Delete all customer entries from ShopAccountXRef
    }
}
