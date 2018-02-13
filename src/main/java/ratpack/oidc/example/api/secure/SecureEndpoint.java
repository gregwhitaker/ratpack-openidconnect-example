package ratpack.oidc.example.api.secure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class SecureEndpoint implements Handler {
    private static final Logger LOG = LoggerFactory.getLogger(SecureEndpoint.class);

    @Override
    public void handle(Context ctx) throws Exception {

    }
}
