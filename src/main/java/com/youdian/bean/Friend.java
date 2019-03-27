package com.youdian.bean;

/**
 * @author hs
 * @date 2019/3/25 - 12:54
 */
public class Friend {
    private int id;
    private String companyname;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
