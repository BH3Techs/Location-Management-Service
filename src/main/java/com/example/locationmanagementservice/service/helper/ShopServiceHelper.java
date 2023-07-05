package com.example.locationmanagementservice.service.helper;

import com.example.locationmanagementservice.model.Shop;
import com.example.locationmanagementservice.model.ShopDetails;
import org.springframework.stereotype.Component;

@Component
public class ShopServiceHelper {

	public ShopDetails convertToShopDomain(Shop shop) {
		
		return ShopDetails.builder()
				.shopID(shop.getShopID())
				.shopName(shop.getShopName())
				.shopType(shop.getShopType())
				.build();
	}
	
	public Shop convertToShopEntity(ShopDetails shopDetails) {
		
		
		return Shop.builder()
				.shopID(shopDetails.getShopID())
				.shopName(shopDetails.getShopName())
				.shopType(shopDetails.getShopType())
				.build();
	}

}
