package zxf.ldap.mapper;

import org.springframework.ldap.core.AuthenticatedLdapEntryContextMapper;
import org.springframework.ldap.core.LdapEntryIdentification;
import zxf.ldap.bean.LdapUser;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;

public class MyAuthenticatedLdapEntryContextMapper implements AuthenticatedLdapEntryContextMapper<LdapUser> {
    @Override
    public LdapUser mapWithContext(DirContext dirContext, LdapEntryIdentification ldapEntryIdentification) {
        try {
            Attributes attributes = dirContext.getAttributes(ldapEntryIdentification.getRelativeName());
            return new LdapUserAttributeMapper().mapFromAttributes(attributes);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
