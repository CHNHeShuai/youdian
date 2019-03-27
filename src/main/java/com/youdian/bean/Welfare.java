package com.youdian.bean;

/**
 * @author hs
 * @date 2019/3/3 - 11:14
 */
public class Welfare {

    private String miaoshu;
    private String image;
    private int id;

    public String getMiaoshu() {
        return miaoshu;
    }

    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Welfare{" +
                "miaoshu='" + miaoshu + '\'' +
                ", image='" + image + '\'' +
                ", id=" + id +
                '}';
    }
}
