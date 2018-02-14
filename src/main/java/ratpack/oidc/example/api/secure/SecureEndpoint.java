package ratpack.oidc.example.api.secure;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.pac4j.RatpackPac4j;

import java.util.Map;

import static ratpack.groovy.Groovy.groovyTemplate;

public class SecureEndpoint implements Handler {
    private static final Logger LOG = LoggerFactory.getLogger(SecureEndpoint.class);

    @Override
    public void handle(Context ctx) throws Exception {
        RatpackPac4j.userProfile(ctx)
                .then(commonProfile -> {
                    final Map<String, Object> model = Maps.newHashMap();
                    model.put("profile", commonProfile);

                    ctx.render(groovyTemplate(model, "secure.html"));
                });
    }
}
