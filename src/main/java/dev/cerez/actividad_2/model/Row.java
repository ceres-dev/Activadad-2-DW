package dev.cerez.actividad_2.model;

import lombok.Data;

@Data
public class Row {
    private final String name;
    private final String supplier; // proveedor
    private final String category;
    private final String primaryLanguage;
    private final String secondaryLanguage;
    private final Boolean useDB;
    private final Boolean requiresNetwork;
    private final Integer numberOfBits;
    private final String license;
    private final Double price;
    private final String description;
    private final Integer website;
    private final String email;
    private final Long installerSize;
}
