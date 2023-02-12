package zxf.ldap.mapper;

import org.springframework.ldap.core.AttributesMapper;
import zxf.ldap.bean.LdapGroup;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

public class LdapGroupAttributeMapper implements AttributesMapper<LdapGroup> {
    @Override
    public LdapGroup mapFromAttributes(Attributes attributes) throws NamingException {
        LdapGroup ldapGroup = new LdapGroup();
        ldapGroup.setName(attributes.get("name").get().toString());
        return ldapGroup;
    }
}
