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
- DC* (Root/Middle)
- OU* (Middle)
- CN or UID(Leaf)

## LDIF
- 要Escape “,” 请使用\,

## Key Classes
- org.springframework.security.ldap.authentication.LdapAuthenticationProvider