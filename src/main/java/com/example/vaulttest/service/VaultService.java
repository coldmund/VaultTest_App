package com.example.vaulttest.service;

import com.example.vaulttest.vaultInterface.VaultConfig;
import com.example.vaulttest.vo.VaultKv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

@Component
public class VaultService {
    @Autowired
    VaultConfig vaultConfig;

    @Autowired
    VaultTemplate   vaultTemplate;

    public String   testDb1(String str) {
        VaultKv vaultKv = new VaultKv("testKey", str);

        vaultTemplate.write("test1/test11", vaultKv);

        VaultResponseSupport<VaultKv> response = vaultTemplate.read("test1/test11", VaultKv.class);
        System.out.println(response.getData().getKey());

        // vaultTemplate.delete("secret/myapp");

        return  response.getData().getValue();
    }
}
