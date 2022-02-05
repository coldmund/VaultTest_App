package com.example.vaulttest.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TestTable")
@Getter
@ToString
public class TestKv {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Setter
    private String cle;

    @Setter
    @Column(columnDefinition = "TEXT")
    private String prix;

    public  TestKv() {

    }

    public  TestKv(String cle, String prix) {
        this.cle = cle;
        this.prix = prix;
    }
}
