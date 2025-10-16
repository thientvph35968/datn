package com.example.datn.model;

import java.math.BigDecimal;

public class Product {
    private String name;
    private String imageUrl;
    private BigDecimal salePrice;
    private BigDecimal originalPrice;

    public Product(String name, String imageUrl, BigDecimal salePrice, BigDecimal originalPrice) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.salePrice = salePrice;
        this.originalPrice = originalPrice;
    }

    // Getters và setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public BigDecimal getSalePrice() { return salePrice; }
    public void setSalePrice(BigDecimal salePrice) { this.salePrice = salePrice; }

    public BigDecimal getOriginalPrice() { return originalPrice; }
    public void setOriginalPrice(BigDecimal originalPrice) { this.originalPrice = originalPrice; }
}
