package com.example.temporal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ScannerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    long siteId;
    long lat;
    long lon;
    String mac;

    public ScannerModel(long siteId, long lat, long lon, String mac) {
        this.siteId = siteId;
        this.lat = lat;
        this.lon = lon;
        this.mac = mac;
    }
}

// add this to the main table
