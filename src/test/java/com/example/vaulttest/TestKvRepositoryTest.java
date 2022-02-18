package com.example.vaulttest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.example.vaulttest.db.TestKv;
import com.example.vaulttest.db.TestKvRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestKvRepositoryTest {
    @Autowired
    private TestKvRepository testKvRepository;

    @Before
    public void setUp() throws Exception {
        testKvRepository.deleteAll();

        TestKv testKv1 = new TestKv("foo", "bar");
        TestKv testKv2 = new TestKv("hello", "world");
        assertNull(testKv1.getId());
        assertNull(testKv2.getId());
        this.testKvRepository.save(testKv1);
        this.testKvRepository.save(testKv2);
        assertNotNull(testKv1.getId());
        assertNotNull(testKv2.getId());
    }

    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        TestKv testKv1 = testKvRepository.findByCle("foo");
        assertNotNull(testKv1);
        assertEquals("bar", testKv1.getPrix());
        long count = testKvRepository.findAll().spliterator().getExactSizeIfKnown();
        assertEquals(count, 2);
    }
}
