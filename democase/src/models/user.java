package models;

public class user extends Account {
    private String order;

    public user(String order) {
        this.order = order;
    }

    public user(String name, String userName, String passWord, String email, String rights, String order) {
        super(name, userName, passWord, email, rights);
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public user() {
    }

    @Override
    public String toString() {
        return "user{" +
                "order='" + order + '\'' +
                '}';
    }
}
