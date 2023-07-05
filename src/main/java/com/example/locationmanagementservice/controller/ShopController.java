package com.example.locationmanagementservice.controller;

import com.example.locationmanagementservice.model.ShopDetails;
import com.example.locationmanagementservice.service.impl.ShopServiceImpl;
//import io.swagger.annotations.Api;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 5/7/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * LocationManagementService
 **/

@RestController
@RequestMapping("/shop")
@Api(tags = { "Shop REST endpoints" })
public class ShopController {

    @Autowired
    private ShopServiceImpl shopService;

    @GetMapping(path = "/all")
    @ApiOperation(value = "Find all shop", notes = "Gets details of all the shop")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })

    public List<ShopDetails> getAllShop() {

        return shopService.findAll();
    }

    @PostMapping(path = "/add")
    @ApiOperation(value = "Add a Shop", notes = "Add shop and create an account")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })

    public ResponseEntity<Object> addShop(@RequestBody ShopDetails shop) {

        return shopService.addShop(shop);
    }

    @GetMapping(path = "/{shopID}")
    @ApiOperation(value = "Get shop details", notes = "Get Shop details by shop id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ShopDetails.class, responseContainer = "Object"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })

    public ShopDetails getShop(@PathVariable Long shopID) {

        return shopService.findByShopNumber(shopID);
    }

//	@PutMapping(path = "/{shopNumber}")
//	@ApiOperation(value = "Update shop", notes = "Update shop and any other account information associated with him.")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class),
//			@ApiResponse(code = 400, message = "Bad Request"),
//			@ApiResponse(code = 500, message = "Internal Server Error") })
//
//	public ResponseEntity<Object> updateShop(@RequestBody ShopDetails shopDetails,
//			@PathVariable Long shopNumber) {
//
//		return shopService.updateShop(shopDetails, shopNumber);
//	}

    @DeleteMapping(path = "/{shopID}")
    @ApiOperation(value = "Delete shop and related accounts", notes = "Delete shop and all accounts associated with him.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Object.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })

    public ResponseEntity<Object> deleteShop(@PathVariable Long shopNumber) {

        return shopService.deleteShop(shopNumber);
    }
}
