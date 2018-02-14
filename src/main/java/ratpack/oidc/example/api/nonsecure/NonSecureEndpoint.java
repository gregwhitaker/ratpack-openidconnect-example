package ratpack.oidc.example.api.nonsecure;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.pac4j.RatpackPac4j;

import java.util.Map;

import static ratpack.groovy.Groovy.groovyTemplate;

public class NonSecureEndpoint implements Handler {
    private static final Logger LOG = LoggerFactory.getLogger(NonSecureEndpoint.class);

    @Override
    public void handle(Context ctx) throws Exception {
        RatpackPac4j.userProfile(ctx)
                .then(commonProfile -> {
                    // If the profile is logged in go ahead and return it on all pages secured or not.
                    final Map<String, Object> model = Maps.newHashMap();
                    model.put("profile", commonProfile);

                    ctx.render(groovyTemplate(model, "nonsecure.html"));
                });
    }
}
