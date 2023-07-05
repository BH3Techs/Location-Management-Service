package com.example.locationmanagementservice.shopRepo;

import com.example.locationmanagementservice.model.Shop;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 5/7/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * LocationManagementService
 **/
@Repository
public interface ShopRepo extends CrudRepository<Shop, Long> {
    Optional<Shop> findShopByShopID(Long shopId);
}