package ratpack.oidc.example.api.nonsecure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class NonSecureEndpoint implements Handler {
    private static final Logger LOG = LoggerFactory.getLogger(NonSecureEndpoint.class);

    @Override
    public void handle(Context ctx) throws Exception {

    }
}
