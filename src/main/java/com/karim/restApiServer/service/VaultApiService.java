package com.karim.restApiServer.service;

import com.google.gson.JsonObject;
import com.karim.restApiServer.configuration.VaultProps;
import com.karim.restApiServer.global.VaultCredential;
import com.karim.restApiServer.global.VaultTemplateInstance;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.vault.authentication.AppRoleAuthentication;
import org.springframework.vault.authentication.AppRoleAuthenticationOptions;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultVersionedKeyValueTemplate;
import org.springframework.vault.support.Versioned;

/**
 * packageName    : com.karim.restApiServer.service
 * author         : sblim
 * date           : 2022-06-16 오전 11:39
 * description    :
 */
@Configuration
@EnableConfigurationProperties(VaultProps.class)
@RequiredArgsConstructor
public class VaultApiService extends AbstractVaultConfiguration {

    final private VaultProps vaultProperties;

    @Override
    public VaultEndpoint vaultEndpoint() {
        VaultEndpoint vaultEndpoint = null;
        if (vaultProperties != null) {
            vaultEndpoint = VaultEndpoint.create(vaultProperties.getHost(), vaultProperties.getPort());
            vaultEndpoint.setScheme(vaultProperties.getSchema());
        }
        return vaultEndpoint;
    }

    @Override
    public ClientAuthentication clientAuthentication() {
        AppRoleAuthenticationOptions appRoleAuthenticationOptions = null;
        if (vaultProperties != null) {
            appRoleAuthenticationOptions = AppRoleAuthenticationOptions.builder()
                    .roleId(AppRoleAuthenticationOptions.RoleId.provided(vaultProperties.getRoleId()))
                    .secretId(AppRoleAuthenticationOptions.SecretId.provided(vaultProperties.getSecretId()))
                    .build();
        }
        return appRoleAuthenticationOptions != null ? new AppRoleAuthentication(appRoleAuthenticationOptions, restOperations()) : null;
    }

    @Bean
    @Primary
    public void readVaultCredentials() {
        VaultTemplate vaultTemplate = new VaultTemplate(vaultEndpoint(), clientAuthentication());
        VaultVersionedKeyValueTemplate vaultVersionedKeyValueTemplate;
        vaultVersionedKeyValueTemplate = new VaultVersionedKeyValueTemplate(vaultTemplate, vaultProperties.getMainPath());

        try {
            Versioned<VaultCredential> vaultResponse = vaultVersionedKeyValueTemplate.get("/" + vaultProperties.getSubPath(), VaultCredential.class);

            if (vaultResponse != null){
                VaultTemplateInstance.getInstance().put("user",vaultResponse.getData().getUsername());
                VaultTemplateInstance.getInstance().put("auth",vaultResponse.getData().getPassword());
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}