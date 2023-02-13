# Key Classes
## Spring
- org.springframework.ldap.core.support.DirContextAuthenticationStrategy;
- org.springframework.ldap.core.support.SimpleDirContextAuthenticationStrategy;
- org.springframework.ldap.core.support.DigestMd5DirContextAuthenticationStrategy;
- org.springframework.ldap.core.support.DefaultTlsDirContextAuthenticationStrategy;
- org.springframework.ldap.core.support.ExternalTlsDirContextAuthenticationStrategy;
- org.springframework.ldap.core.LdapOperations;
- org.springframework.ldap.core.LdapTemplate;
- org.springframework.ldap.core.ContextSource;
- org.springframework.ldap.core.support.LdapContextSource;
- org.springframework.ldap.core.DirContextOperations;
- org.springframework.ldap.core.DirContextAdapter;
- org.springframework.ldap.core.AttributesMapper;
- org.springframework.ldap.core.NameAwareAttributes;
## JavaX
- javax.naming.directory.Attribute;
- javax.naming.directory.Attributes;
- javax.naming.directory.DirContext;
- javax.naming.ldap.InitialLdapContext;
- javax.naming.spi.NamingManager;
- javax.naming.spi.InitialContextFactory;
## Sun
- com.sun.jndi.ldap.LdapCtx;
- com.sun.jndi.ldap.LdapCtxFactory

# how to get cert chain of an LDAP serer
- openssl s_client -connect ldap-server:port -showcerts

# install ca certs
- keytool -import -storetype jks -keystore truststore.jks -storepass changeit -alias <ca-name> -file <ca-cert>.pem