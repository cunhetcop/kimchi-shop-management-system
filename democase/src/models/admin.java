package models;

public class admin extends Account{
    private String permission;

    public admin(String permission) {
        this.permission = permission;
    }

    public admin(String name, String userName, String passWord, String email, String rights, String permission) {
        super(name, userName, passWord, email, rights);
        this.permission = permission;
    }

    public admin() {
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "admin{" +
                "permission='" + permission + '\'' +
                '}';
    }
}
