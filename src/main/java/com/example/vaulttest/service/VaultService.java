package com.example.vaulttest.service;

import java.util.HashMap;
import java.util.Map;

import com.example.vaulttest.vaultInterface.VaultConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.support.VaultResponseSupport;

@Component
public class VaultService {
    @Autowired
    VaultConfig vaultConfig;

    @Autowired
    VaultTemplate   vaultTemplate;

    // test KV version 1
    public String   testDb1(String str) {
        Map<String, String> in = new HashMap<String, String>();
        in.put("testKey", str);

        vaultTemplate.write("test1/test11", in);

        String  result = (String)vaultTemplate.read("test1/test11", HashMap.class).getData().get("testKey");
        System.out.println(result);

        // vaultTemplate.delete("secret/myapp");

        return  result;
    }

    // test KV version 2
    public String   testDb2(String str) {
        VaultKeyValueOperations op = vaultTemplate.opsForKeyValue("test2", KeyValueBackend.KV_2);
        Map<String, String> in = new HashMap<String, String>();
        // op.put("test22", in);
        // in.put("testKey", str);
        in.put(str, str);
        op.patch("test22", in);
        // String  result = (String)op.get("test22").getData().get("testKey");
        String  result = (String)op.get("test22").getData().get(str);
        System.out.println(result);
        return  result;
    }
}
