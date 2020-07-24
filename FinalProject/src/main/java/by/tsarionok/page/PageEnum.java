package by.tsarionok.page;

import by.tsarionok.entity.Role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum PageEnum {
    HOME("/home", Role.USER),
    CONTROLLER("/controller", Role.ADMIN);

    private String pageUri;
    private Set<Role> allowRoles = new HashSet<>();

    PageEnum(final String uri, final Role... roles) {
        pageUri = uri;
        allowRoles.addAll(Arrays.asList(roles));
    }

    public String getPageUri() {
        return pageUri;
    }

    public Set<Role> getAllowRoles() {
        return allowRoles;
    }
}
