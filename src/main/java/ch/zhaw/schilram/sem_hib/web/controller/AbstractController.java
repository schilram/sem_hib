package ch.zhaw.schilram.sem_hib.web.controller;

/**
 * @author rschilling
 */
public abstract class AbstractController {

    /**
     * Creates a redirect view path.
     * @param requestMapping    The request mapping of target controller method.
     * @return  The created redirect view path.
     */
    protected String createRedirectViewPath(final String requestMapping) {
        final StringBuilder redirectViewPath = new StringBuilder();
        redirectViewPath.append("redirect:");
        redirectViewPath.append(requestMapping);
        return redirectViewPath.toString();
    }
}
