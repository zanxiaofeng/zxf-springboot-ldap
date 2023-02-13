package zxf.ldap.service;

import com.sun.jndi.ldap.LdapCtx;
import com.sun.jndi.ldap.LdapCtxFactory;
import zxf.ldap.bean.LdapGroup;
import zxf.ldap.bean.LdapUser;
import zxf.ldap.mapper.LdapGroupAttributeMapper;
import zxf.ldap.mapper.LdapUserAttributeMapper;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import java.util.ArrayList;
import java.util.List;

public class LdapServiceBySun extends LdapServiceBase {
    public List<LdapGroup> listGroups() throws NamingException {
        LdapCtx ldapCtx = createContext();
        //Do not include BASE-DC
        NamingEnumeration<SearchResult> results = ldapCtx.search("OU=HK,OU=Groups", "(objectClass=group)", getDefaultSearchControls());

        List<LdapGroup> groups = new ArrayList<>();
        while (results.hasMore()) {
            groups.add(new LdapGroupAttributeMapper().mapFromAttributes(results.next().getAttributes()));
        }
        return groups;
    }

    public LdapGroup findGroup() throws NamingException {
        LdapCtx ldapCtx = createContext();
        //Do not include BASE-DC
        Attributes attributes = ldapCtx.getAttributes("CN=HR,OU=HK,OU=Groups");
        return new LdapGroupAttributeMapper().mapFromAttributes(attributes);
    }

    public LdapUser authenticate() throws NamingException {
        LdapCtx ldapCtx = createContext("CN=Davis,OU=People,DC=zxf,DC=com", "*****");
        //Do not include BASE-DC
        Attributes attributes = ldapCtx.getAttributes("CN=Davis,OU=People");
        return new LdapUserAttributeMapper().mapFromAttributes(attributes);
    }


    private LdapCtx createContext() throws NamingException {
        return createContext("CN=DEV,OU=Service,DC=zxf,DC=com", "*****");
    }

    private LdapCtx createContext(String principal, String credentials) throws NamingException {
        return (LdapCtx) new LdapCtxFactory().getInitialContext(getAuthenticatedEnv(principal, credentials));
    }
}
