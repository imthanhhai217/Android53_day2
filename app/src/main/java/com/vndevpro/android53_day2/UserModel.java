package com.vndevpro.android53_day2;

import java.io.Serializable;

public class UserModel implements Serializable {

    private String userName, address;

    public UserModel(String userName, String address) {
        this.userName = userName;
        this.address = address;
    }

    public UserModel() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
