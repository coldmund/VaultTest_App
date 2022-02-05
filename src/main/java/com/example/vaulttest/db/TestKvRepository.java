package com.example.vaulttest.db;

import org.springframework.data.repository.CrudRepository;

public interface TestKvRepository extends CrudRepository<TestKv, Integer> {
    TestKv  findByCle(String clekey);
}
