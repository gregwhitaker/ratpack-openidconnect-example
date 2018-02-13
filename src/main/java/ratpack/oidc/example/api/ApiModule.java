package ratpack.oidc.example.api;

import com.google.inject.AbstractModule;
import ratpack.oidc.example.api.nonsecure.NonSecureEndpoint;
import ratpack.oidc.example.api.secure.SecureEndpoint;

public class ApiModule extends AbstractModule {
    
    @Override
    protected void configure() {
        bind(ApiEndpoints.class);

        bind(NonSecureEndpoint.class);
        bind(SecureEndpoint.class);
    }
}
