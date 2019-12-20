package net.treXis.tipsy.viewer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
public class ResourceServerConfigRemoteTokenService {

    @Primary
    @Bean
    public RemoteTokenServices tokenService() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl("http://localhost:8080/spring-security-oauth-server/oauth/check_token");
        tokenService.setClientId("fooClientIdPassword");
        tokenService.setClientSecret("secret");
        return tokenService;
    }

}

// RemoteTokenService will use CheckTokenEndPoint on Authorization Server to validate AccessToken and obtain Authentication
// found at AuthorizationServerBaseURL +”/oauth/check_token“
// Authorization Server can use any TokenStore type [JdbcTokenStore, JwtTokenStore, …]
