package ratpack.oidc.example.api;

import org.pac4j.oidc.client.GoogleOidcClient;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.oidc.example.api.nonsecure.NonSecureEndpoint;
import ratpack.oidc.example.api.secure.SecureEndpoint;
import ratpack.pac4j.RatpackPac4j;

public class ApiEndpoints implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain.get("nonsecure", NonSecureEndpoint.class);

        chain.prefix("secure", c1 -> {
            RatpackPac4j.requireAuth(GoogleOidcClient.class);
            c1.get(SecureEndpoint.class);
        });
    }
}
