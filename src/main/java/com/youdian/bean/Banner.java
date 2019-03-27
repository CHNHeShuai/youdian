package com.youdian.bean;

/**
 * @author hs
 * @date 2019/3/3 - 13:06
 */
public class Banner {
    private int id;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", image='" + image + '\'' +
                '}';
    }
}
