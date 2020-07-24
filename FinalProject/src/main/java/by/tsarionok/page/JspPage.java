package by.tsarionok.page;

import by.tsarionok.entity.Role;

import java.util.HashSet;
import java.util.Set;

public class JspPage {
    private String uri;
    private Set<Role> allowRoles = new HashSet<>();
    private boolean isRedirect = false;
    private StringBuilder parameters = new StringBuilder();

    public JspPage(String pageUri, Set<Role> roles) {
        this.uri = pageUri;
        this.allowRoles.addAll(roles);
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public String getUri() {
        return uri;
    }

    public Set<Role> getAllowRoles() {
        return allowRoles;
    }

    public String getParameters() {
        return parameters.toString();
    }

    public void addParameter(String name, String value) {
        if (parameters.toString().isEmpty()) {
            parameters.append("?");
        } else {
            parameters.append("&");
        }
        parameters.append(name)
                .append("=")
                .append(value);
    }
}
