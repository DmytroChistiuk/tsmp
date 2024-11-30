package tsmp.core.utils;

import com.adobe.aemds.guide.utils.JcrResourceConstants;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import javax.jcr.Session;
import java.util.Collections;

public class CQUtils {
    public static ResourceResolver getResourceResolver(Session session, ResourceResolverFactory resourceResolverFactory) throws LoginException {
        return resourceResolverFactory.getResourceResolver(Collections.singletonMap(JcrResourceConstants.AUTHENTICATION_INFO_SESSION, session));
    }
}
