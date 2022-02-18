package com.example.vaulttest.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "test_table")
@AllArgsConstructor
@NoArgsConstructor
public class TestKv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cle;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String prix;

    public  TestKv(String cle, String prix) {
        this.cle = cle;
        this.prix = prix;
    }
}
