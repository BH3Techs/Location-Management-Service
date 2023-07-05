package com.example.locationmanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * 5/7/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * LocationManagementService
 **/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Shop {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;

    private Long shopID;
    private String shopName;
    private String shopType;

    @ManyToOne(cascade=CascadeType.ALL)
    private Area areaID;

}
