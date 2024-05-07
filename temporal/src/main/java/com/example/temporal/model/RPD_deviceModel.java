package com.example.temporal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RPD_deviceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(unique = true)
    String mac;
    String gateway="0.0.0.0";
    String subnet="0";
    String assigned_ip="192.168.2.37";
    String management_ip="10.15.23.199";
    String serialNumber;
    String status="offline";
    String discoveryMode="normal";
    String vendor;
    String model;
    String version="1.0.2.7";

    public RPD_deviceModel(String name, String mac, String serialNumber, String vendor, String model) {
        this.name = name;
        this.mac = mac;
        this.serialNumber = serialNumber;
        this.vendor = vendor;
        this.model = model;
    }
}
