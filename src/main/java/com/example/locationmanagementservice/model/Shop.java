package com.example.locationmanagementservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

/**
 * 5/7/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * LocationManagementService
 **/
@Data
public class Shop {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String ShopID;
    private String ShopName;
    private String ShopType;

    @ManyToOne(cascade= CascadeType.ALL)
    private Area areaID;

}
