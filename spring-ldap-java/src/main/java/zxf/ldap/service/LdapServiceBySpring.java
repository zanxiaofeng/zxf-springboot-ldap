package zxf.ldap.service;

import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQueryBuilder;
import zxf.ldap.bean.LdapGroup;
import zxf.ldap.bean.LdapUser;
import zxf.ldap.mapper.LdapGroupAttributeMapper;
import zxf.ldap.mapper.LdapUserAttributeMapper;
import zxf.ldap.mapper.MyAuthenticatedLdapEntryContextMapper;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import java.util.ArrayList;
import java.util.List;

public class LdapServiceBySpring extends LdapServiceBase {
    public List<LdapGroup> listGroups() throws NamingException {
        //Do not include BASE-DC
        AndFilter filter = new AndFilter().and(new EqualsFilter("objectClass", "group"));
        return getLdapTemplate().search("OU=HK,OU=Groups", filter.encode(), new LdapGroupAttributeMapper());
    }

    public LdapGroup findGroup() throws NamingException {
        //Do not include BASE-DC
        return getLdapTemplate().lookup("CN=HR,OU=HK,OU=Groups", new LdapGroupAttributeMapper());
    }

    public LdapUser findUser() throws NamingException {
        //Do not include BASE-DC
        DirContextAdapter dirContextAdapter = (DirContextAdapter) getLdapTemplate().lookup("CN=HR,OU=HK,OU=Groups");
        return new LdapUserAttributeMapper().mapFromAttributes(dirContextAdapter.getAttributes());
    }

    public LdapUser authenticate() throws NamingException {
        //Do not include BASE-DC
        return getLdapTemplate().authenticate(LdapQueryBuilder.query().base("OU=People").where("CN").is("Andy"),
                "******", new MyAuthenticatedLdapEntryContextMapper());
    }


    private LdapTemplate getLdapTemplate() throws NamingException {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldaps://ldap-server:port");
        contextSource.setUserDn("CN=Davis,OU=People,DC=zxf,DC=com");
        contextSource.setPassword("******");
        contextSource.setBase("DC=zxf,DC=com");
        contextSource.setPooled(true);
        contextSource.afterPropertiesSet();
        return new LdapTemplate(contextSource);
    }

}
