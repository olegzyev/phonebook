package com.sber_tech.domain;

public class Contact {
    private String fullname;
    private String address;
    private String number;

    public Contact(String name, String address, String numberphone) {
        this.fullname = name;
        this.address = address;
        this.number = numberphone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String numberphone) {
        this.number = numberphone;
    }

    @Override
    public String toString() {
        return "Contact [Fullname=" + fullname + ", Address=" + address + ", NumberPhone=" + number + "]";
    }

}
