# Embedded UnboundID Server
```
<dependency>
	<groupId>com.unboundid</groupId>
	<artifactId>unboundid-ldapsdk</artifactId>
	<version>4.0.14</version>
	<scope>runtime</scope>
</dependency>
```

# Embedded ApacheDS Server
```
<dependency>
	<groupId>org.apache.directory.server</groupId>
	<artifactId>apacheds-core</artifactId>
	<version>1.5.5</version>
	<scope>runtime</scope>
</dependency>
<dependency>
	<groupId>org.apache.directory.server</groupId>
	<artifactId>apacheds-server-jndi</artifactId>
	<version>1.5.5</version>
	<scope>runtime</scope>
</dependency>
```

# LDAP Structure

## Entry(条目)
- 每个对象在目录树中叫做一个LDAP条目，由DN唯一标识，例如：uid=joe,ou=people,cd=springframework,dc=org
- 
## Attribute(属性)
- 每个条目除了由DN唯一标识外，还可以有很多属性来描述，比如：姓、名，邮箱、商业单位等，可以是标准属性（采用标准属性名），也可以是自定义属性（使用自定义属性名）
- 常用标准属性名有：dc, ou, cn, uid, sn, mail, objectclass
- 
## Distinguishing Name/DN
- 在ＬＤＡＰ中识别一个条目，我们使用ＤＮ，ＤＮ在一个目录中是全局唯一的，它的值是表示该条目在目录树中的位置，可以被“连接”为当前条目的名字和它的父节点一直到顶层根节点的条目“相加”

## 层级结构
### DNS-based LDAP tree
- DC* (Root/Middle)
- OU* (Middle)
- CN or UID(Leaf)
### Other
- O*
- CN

## Ldap Url
- ```ldap[s]://<hostname>:<port>/<base_dn>?<attributes>?<scope>?<filter>```

|  Component  | Description |
|-------------|-------------|
|`<hostname>`|Name (or IP address in dotted format) of the LDAP server (for example, ldap.netscape.com or 192.202.185.90). |
|`<port>`|Port number of the LDAP server (for example, 696).<br>If no port is specified, the standard LDAP port (389) is used. |
|`<base_dn>`|Distinguished name (DN) of an entry in the directory. This DN identifies the entry that is starting point of the search.<br>If this component is empty, the search starts at the root DN. |
|`<attributes>`|The attributes to be returned. To specify more than one attribute, use commas to delimit the attributes (for example, "cn,mail,telephoneNumber").<br>If no attributes are specified in the URL, all attributes are returned. |
|`<scope>`|The scope of the search, which can be one of these values:<br> - base retrieves information only about the distinguished name (<base_dn>) specified in the URL.<br> - one retrieves information about entries one level below the distinguished name (<base_dn>) specified in the URL. The base entry is not included in this scope.<br> - sub retrieves information about entries at all levels below the distinguished name (<base_dn>) specified in the URL. The base entry is included in this scope.<br>If no scope is specified, the server performs a base search. |
|`<filter>`|Search filter to apply to entries within the specified scope of the search.<br>If no filter is specified, the server uses the filter (objectClass=*).|

## LDIF
- 要Escape “,” 请使用\,

## Key Classes
- org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer
- org.springframework.security.ldap.authentication.LdapAuthenticationProvider
- org.springframework.ldap.core.support.BaseLdapPathContextSource[interface]
- org.springframework.ldap.core.support.DirContextSource
- org.springframework.ldap.core.support.LdapContextSource
- org.springframework.security.ldap.DefaultSpringSecurityContextSource
- org.springframework.security.ldap.ppolicy.PasswordPolicyAwareContextSource
- org.springframework.security.ldap.authentication.LdapAuthenticator[interface]
- org.springframework.security.ldap.authentication.BindAuthenticator
- org.springframework.security.ldap.authentication.PasswordComparisonAuthenticator
- org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator[interface]
- org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator
- org.springframework.security.ldap.authentication.UserDetailsServiceLdapAuthoritiesPopulator
- org.springframework.security.ldap.userdetails.UserDetailsContextMapper[interface]
- org.springframework.security.ldap.userdetails.LdapUserDetailsMapper
- org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper[interface]
- org.springframework.security.core.authority.mapping.SimpleAuthorityMapper
- ~/.m2/repository/org/springframework/security/spring-security-config/5.6.5/spring-security-config-5.6.5.jar!/org/springframework/security/config/spring-security-2.0.xsd