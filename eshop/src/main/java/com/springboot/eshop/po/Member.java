package com.springboot.eshop.po;

public class Member {

    private Integer mid;
    private String name;
    private String pass;
    private String email;
    private String tel;
    private Integer gender;

    public Member() {
    }

    public String toString() {
        return "Member{mid=" + this.mid + ", name='" + this.name + '\'' + ", pass='" + this.pass + '\'' + ", email='" + this.email + '\'' + ", tel='" + this.tel + '\'' + ", gender=" + this.gender + '}';
    }

    public Integer getMid() {
        return this.mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
