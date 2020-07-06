package com.GYB.Mybatis.domain;

public class AccountUser extends Account {
    private String username;
    private String address;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 注意这个toString的写法，加了一个 ’ super.toString() ‘
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "AccountUSer{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
