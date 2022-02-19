package com.example.vaulttest.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.example.vaulttest.db.TestKv;
import com.example.vaulttest.db.TestKvRepository;
import com.example.vaulttest.vaultInterface.VaultConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultTransitOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.support.VaultResponse;

@Component
public class VaultService {
    @Autowired
    VaultConfig vaultConfig;

    @Autowired
    VaultTemplate   vaultTemplate;

    @Autowired
    TestKvRepository    testKvRepository;

    // test KV version 1
    public String   testKv1(String str) {
        Map<String, String> in = new HashMap<String, String>();
        in.put("testKey", str);

        vaultTemplate.write("test1/test11", in);

        String  result = (String)vaultTemplate.read("test1/test11", HashMap.class).getData().get("testKey");
        System.out.println(result);

        // vaultTemplate.delete("secret/myapp");

        return  result;
    }

    // test KV version 2 - put/get
    public String   testKv2(String str) {
        VaultKeyValueOperations op = vaultTemplate.opsForKeyValue("test2", KeyValueBackend.KV_2);
        Map<String, String> in = new HashMap<String, String>();
        in.put(str, str);
        op.put("test22", in);
        String  result = (String)op.get("test22").getData().toString();
        System.out.println(result);
        return  result;
    }

    // test KV version 2 - patch/get
    public String   testKv3(String str) {
        VaultKeyValueOperations op = vaultTemplate.opsForKeyValue("test2", KeyValueBackend.KV_2);
        Map<String, String> in = new HashMap<String, String>();
        in.put(str, str);
        op.patch("test22", in);
        String  result = (String)op.get("test22").getData().toString();
        System.out.println(result);
        return  result;
    }

    public String   testEnc(String str) {
        VaultTransitOperations  op = vaultTemplate.opsForTransit();
        String  result = op.encrypt("orders", str);
        System.out.println(result);
        return  result;
    }

    public String   testDec(String str) {
        VaultTransitOperations  op = vaultTemplate.opsForTransit();
        String  result = op.decrypt("orders", str);
        System.out.println(result);
        return  result;
    }

    public String   testDb(String str) {
        TestKv  testKv = new TestKv(str, Base64.getEncoder().encodeToString(str.getBytes()));
        // get DB credential
        VaultResponse   response = vaultTemplate.read("database/creds/vaultrole");
        String  username = (String)response.getData().get("username");
        String  password = (String)response.getData().get("password");
        System.out.println("username: " + username + ", password: " + password);

        testKvRepository.save(testKv);
        return  testKvRepository.findByCle(str).getPrix();
    }
}
