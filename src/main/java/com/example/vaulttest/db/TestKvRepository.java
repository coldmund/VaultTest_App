package com.example.vaulttest.db;

import org.springframework.data.repository.CrudRepository;

public interface TestKvRepository extends CrudRepository<TestKv, Long> {
    public TestKv  findByCle(String cle);
}
