package com.example.locationmanagementservice.shopRepo;

import com.example.locationmanagementservice.model.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 5/7/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * LocationManagementService
 **/
@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
    Optional<Shop> findByShopID(Long customerNumber);
}