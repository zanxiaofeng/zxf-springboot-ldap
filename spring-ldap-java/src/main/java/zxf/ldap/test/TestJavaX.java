package zxf.ldap.test;

import zxf.ldap.bean.LdapGroup;
import zxf.ldap.bean.LdapUser;
import zxf.ldap.service.LdapServiceByJavaX;
import zxf.ldap.ssl.SSLInitializer;

import javax.naming.NamingException;

public class TestJavaX {
    public static void main(String[] args) throws NamingException {
        SSLInitializer.initial();

        LdapServiceByJavaX ldapService = new LdapServiceByJavaX();

        //When auth failed, will get a javax.naming.AuthenticationException
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
    }
}
