/**
 * 版权所有©深航渔
 */
package com.shenhangyu.icard.icardweb.config;

import org.apache.commons.codec.binary.Base64;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *描述：获取密钥
 *@author moshenghang
 *@create 2020/4/14 0014 22:07
 */
@Configuration
@ConfigurationProperties(prefix="msh.security",ignoreNestedProperties=false)
public class ISecurityConfig {
    private String secretkey;

    public String getSecretkey() {
        return new String(Base64.decodeBase64(secretkey.getBytes()));
    }

    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }
}
