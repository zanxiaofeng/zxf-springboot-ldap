package zxf.ldap.bean;

public class LdapGroup {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "LdapGroup{" +
                "name='" + name + '\'' +
                '}';
    }
}
