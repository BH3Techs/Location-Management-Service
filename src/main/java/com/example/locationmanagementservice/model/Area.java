package com.example.locationmanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.UUID;

/**
 * 5/7/2023
 *
 * @author bhugs -"Howard Mabhugu"
 * nmbapp
 **/
@Data
public class Area {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String AreaID;
    private String AreaName;
    private String AreaType;
    private String AreaCode;
    private String ParentalAreaID;

}
