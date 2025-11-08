package com.sistema.gestao_empresarial.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String name;
    
    @NonNull
    @Column(nullable = false, unique = true, length = 50)
    private String barcode;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NonNull
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal purchasePrice;
    
    @NotNull
    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal sellingPrice;

    @NotNull
    @Column(nullable = false)
    private Integer stockQuantity;

    @NonNull
    @Column(nullable = false)
    private Integer minimumStock = 0;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
