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
 * nmbapp
 **/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Area {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private Long areaID;
    private String areaName;
    private String areaType;
    private String areaCode;
    private String parentalAreaID;

}
