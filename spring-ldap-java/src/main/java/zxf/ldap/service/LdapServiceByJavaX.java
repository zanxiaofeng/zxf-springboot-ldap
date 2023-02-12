package zxf.ldap.service;

import zxf.ldap.bean.LdapGroup;
import zxf.ldap.bean.LdapUser;
import zxf.ldap.mapper.LdapGroupAttributeMapper;
import zxf.ldap.mapper.LdapUserAttributeMapper;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import java.util.*;

public class LdapServiceByJavaX {
    public List<LdapGroup> listGroups() throws NamingException {
        DirContext dirContext = createDirContext();
        //Do not include BASE-DC
        NamingEnumeration<SearchResult> results = dirContext.search("OU=HK,OU=Groups", "(objectClass=group)", getDefaultSearchControls());
        List<LdapGroup> groups = new ArrayList<>();
        while (results.hasMore()) {
            groups.add(new LdapGroupAttributeMapper().mapFromAttributes(results.next().getAttributes()));
        }
        return groups;
    }

    public LdapGroup findGroup() throws NamingException {
        DirContext dirContext = createDirContext();
        //Do not include BASE-DC
        Attributes attributes = dirContext.getAttributes("CN=HR,OU=HK,OU=Groups");
        return new LdapGroupAttributeMapper().mapFromAttributes(attributes);
    }

    public LdapUser authenticate() throws NamingException {
        DirContext dirContext = createDirContext("CN=Davis,OU=People,DC=zxf,DC=com", "*****");
        //Do not include BASE-DC
        Attributes attributes = dirContext.getAttributes("CN=Davis,OU=People");
        return new LdapUserAttributeMapper().mapFromAttributes(attributes);
    }


    private DirContext createDirContext() throws NamingException {
        return new InitialLdapContext(getAuthenticatedEnv("CN=DEV,OU=Service,DC=zxf,DC=com", "*****"), null);
    }

    private DirContext createDirContext(String principal, String credentials) throws NamingException {
        return new InitialLdapContext(getAuthenticatedEnv(principal, credentials), null);
    }

    private SearchControls getDefaultSearchControls() {
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setTimeLimit(0);
        controls.setCountLimit(0);
        controls.setReturningObjFlag(false);
        //Return all attrs
        controls.setReturningAttributes(null);
        return controls;
    }

    private Hashtable<String, Object> getAuthenticatedEnv(String principal, String credentials) {
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
