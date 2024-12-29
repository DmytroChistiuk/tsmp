package tsmp.core.utils;

import com.adobe.aemds.guide.utils.JcrResourceConstants;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import javax.jcr.Session;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CQUtils {

    private static final String TSMP_SERVICE_USER = "tsmpSystemUser";
    private static final Map<String, Object> AUTH_INFO = Collections.singletonMap(
            ResourceResolverFactory.SUBSERVICE,
            TSMP_SERVICE_USER);

    private CQUtils() {

    }

    public static ResourceResolver getResourceResolver(Session session, ResourceResolverFactory resourceResolverFactory) throws LoginException {
        return resourceResolverFactory.getResourceResolver(Collections.singletonMap(JcrResourceConstants.AUTHENTICATION_INFO_SESSION, session));
    }

    public static ResourceResolver getResourceResolver(ResourceResolverFactory resourceResolverFactory) throws LoginException {
        return resourceResolverFactory.getServiceResourceResolver(AUTH_INFO);
    }
}
