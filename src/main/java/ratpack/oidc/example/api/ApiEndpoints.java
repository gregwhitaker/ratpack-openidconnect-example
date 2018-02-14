package ratpack.oidc.example.api;

import org.pac4j.oidc.client.GoogleOidcClient;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.oidc.example.api.nonsecure.NonSecureEndpoint;
import ratpack.oidc.example.api.secure.SecureEndpoint;
import ratpack.pac4j.RatpackPac4j;

import static ratpack.groovy.Groovy.groovyTemplate;

public class ApiEndpoints implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        // Endpoint that does not require the user to be logged in
        chain.get("nonsecure", NonSecureEndpoint.class);

        // Endpoint that requires the user to be logged in
        chain.prefix("secure", c -> {
            c.all(RatpackPac4j.requireAuth(GoogleOidcClient.class));
            c.get(SecureEndpoint.class);
        });

        // Logout
        chain.path("logout", ctx ->
                RatpackPac4j.logout(ctx).then(() -> ctx.redirect("index.html"))
        );

        // Main Page
        chain.get("index.html", ctx -> {
            ctx.render(groovyTemplate("index.html"));
        });
    }
}
