package ratpack.oidc.example.auth;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import org.pac4j.oidc.client.GoogleOidcClient;
import org.pac4j.oidc.config.OidcConfiguration;
import ratpack.oidc.example.config.AuthConfig;

public class AuthModule extends AbstractModule {

    @Override
    protected void configure() {
        // Noop
    }

    @Provides
    @Inject
    public GoogleOidcClient googleOidcClient(AuthConfig authConfig) {
        OidcConfiguration oidcConfig = new OidcConfiguration();
        oidcConfig.setClientId(authConfig.clientId);
        oidcConfig.setSecret(authConfig.clientSecret);
        oidcConfig.setUseNonce(true);

        return new GoogleOidcClient(oidcConfig);
    }
}
