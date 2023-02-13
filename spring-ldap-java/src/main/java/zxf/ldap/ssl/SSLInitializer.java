package zxf.ldap.ssl;

public class SSLInitializer {
    public static void initial() {
        System.setProperty("javax.net.debug", "all");
        System.setProperty("java.security.debug", "all");
        //Don't support classpath based filepath
        System.setProperty("javax.net.ssl.trustStore", "./src/main/resources/truststore.jks");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
    }
}
