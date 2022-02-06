package com.example.vaulttest.vaultInterface;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.vault.core.VaultTemplate;

@Configuration
public class VaultConfig extends AbstractVaultConfiguration {
    @Value("${vault.uri}")
    URI vaultUri;
    
    @Value("${vault.token}")
    String  vaultToken;

    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.from(vaultUri);
    }

    @Override
    public ClientAuthentication clientAuthentication() {
        return  new TokenAuthentication(vaultToken);
    }

    @Bean
    public  VaultTemplate   vaultTemplate() {
        return  new VaultTemplate(vaultEndpoint(), clientAuthentication());
    }
}
