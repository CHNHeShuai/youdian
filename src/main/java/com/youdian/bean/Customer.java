package com.youdian.bean;

/**
 * @author hs
 * @date 2019/3/18 - 21:00
 */
public class Customer {
    private int id;
    private String username;
    private String telephone;
    private String linktime;
    private String gbook;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLinktime() {
        return linktime;
    }

    public void setLinktime(String linktime) {
        this.linktime = linktime;
    }

    public String getGbook() {
        return gbook;
    }

    public void setGbook(String gbook) {
        this.gbook = gbook;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", telephone='" + telephone + '\'' +
                ", linktime='" + linktime + '\'' +
                ", gbook='" + gbook + '\'' +
                '}';
    }
}
