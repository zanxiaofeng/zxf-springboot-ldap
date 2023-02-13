package zxf.ldap.service;

import javax.naming.directory.SearchControls;
import java.util.Hashtable;

public class LdapServiceBase {
    protected SearchControls getDefaultSearchControls() {
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setTimeLimit(0);
        controls.setCountLimit(0);
        controls.setReturningObjFlag(false);
        //Return all attrs
        controls.setReturningAttributes(null);
        return controls;
    }

    protected Hashtable<String, Object> getAuthenticatedEnv(String principal, String credentials) {
        Hashtable<String, Object> env = new Hashtable<>();
        env.put("java.naming.provider.url", "ldaps://ldap-server:port/DC=zxf,DC=com");
        env.put("com.sun.jndi.ldap.connect.pool", "true");
        env.put("java.naming.security.authentication", "simple");
        env.put("java.naming.security.principal", principal);
        env.put("java.naming.security.credentials", credentials);
        env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        env.put("java.naming.factory.object", "org.springframework.ldap.core.support.DefaultDirObjectFactory");
        return env;
    }
}
