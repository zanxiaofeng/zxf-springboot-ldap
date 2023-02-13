package zxf.ldap.test;

import zxf.ldap.bean.LdapGroup;
import zxf.ldap.bean.LdapUser;
import zxf.ldap.service.LdapServiceBySpring;
import zxf.ldap.ssl.SSLInitializer;

import javax.naming.NamingException;

public class TestSpring {
    public static void main(String[] args) throws NamingException {
        SSLInitializer.initial();

        LdapServiceBySpring ldapService = new LdapServiceBySpring();

        //When auth failed, will get an org.springframework.ldap.AuthenticationException
        System.out.println("Authenticate:");
        LdapUser user = ldapService.authenticate();
        System.out.println(user);

        System.out.println("findGroups:");
        for (LdapGroup group : ldapService.listGroups()) {
            System.out.println(group);
        }

        System.out.println("findGroup:");
        LdapGroup group = ldapService.findGroup();
        System.out.println(group);

        System.out.println("findUser:");
        System.out.println(ldapService.findUser());

        org.springframework.ldap.core.NameAwareAttributes;
        javax.naming.directory.Attribute;
        javax.naming.directory.Attributes;
        javax.naming.directory.DirContext;
        javax.naming.ldap.InitialLdapContext;
        javax.naming.spi.NamingManager;
        javax.naming.spi.InitialContextFactory;

        com.sun.jndi.ldap.LdapCtx;
        com.sun.jndi.ldap.LdapCtxFactory


    }
}
