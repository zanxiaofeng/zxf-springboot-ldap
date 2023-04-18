package zxf.ldap.mapper;

import org.springframework.ldap.core.AttributesMapper;
import zxf.ldap.bean.LdapUser;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class LdapUserAttributeMapper implements AttributesMapper<LdapUser> {
    @Override
    public LdapUser mapFromAttributes(Attributes attributes) throws NamingException {
        System.out.println("Attributes of User: " + attributes);

        LdapUser ldapUser = new LdapUser();
        ldapUser.setName(attributes.get("name").get().toString());
        ldapUser.setEmail(attributes.get("email").get().toString());
        ldapUser.setPhone(attributes.get("phone").get().toString());
        return ldapUser;
    }
}
