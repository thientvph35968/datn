package com.example.datn.service;

import com.example.datn.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getSaleProducts() {
        List<Product> saleProducts = new ArrayList<>();

        // Dữ liệu mẫu (tạm thời)
        saleProducts.add(new Product(
                "Áo khoác",
                "/1.jpg",
                new BigDecimal("500000"),
                new BigDecimal("1000000")
        ));
        saleProducts.add(new Product(
                "Áo khoác",
                "/2.jpg",
                new BigDecimal("600000"),
                new BigDecimal("1200000")
        ));
        saleProducts.add(new Product(
                "Áo khoác",
                "/3.jpg",
                new BigDecimal("450000"),
                new BigDecimal("900000")
        ));
        saleProducts.add(new Product(
                "Áo khoác",
                "/4.jpg",
                new BigDecimal("450000"),
                new BigDecimal("900000")
        ));
        saleProducts.add(new Product(
                "Áo khoác",
                "/5.jpg",
                new BigDecimal("450000"),
                new BigDecimal("900000")
        ));
        saleProducts.add(new Product(
                "Áo khoác",
                "/6.jpg",
                new BigDecimal("450000"),
                new BigDecimal("900000")
        ));
        saleProducts.add(new Product(
                "Áo khoác",
                "/7.jpg",
                new BigDecimal("450000"),
                new BigDecimal("900000")
        ));
        saleProducts.add(new Product(
                "Áo khoác",
                "/8.jpg",
                new BigDecimal("450000"),
                new BigDecimal("900000")
        ));
        saleProducts.add(new Product(
                "Áo khoác",
                "/9.jpg",
                new BigDecimal("450000"),
                new BigDecimal("900000")
        ));
        saleProducts.add(new Product(
                "Áo khoác",
                "/10.jpg",
                new BigDecimal("450000"),
                new BigDecimal("900000")
        ));
        saleProducts.add(new Product(
                "Áo khoác",
                "/11.jpg",
                new BigDecimal("450000"),
                new BigDecimal("900000")
        ));
        saleProducts.add(new Product(
                "Áo khoác",
                "/12.jpg",
                new BigDecimal("450000"),
                new BigDecimal("900000")
        ));
        return saleProducts;
    }
}
