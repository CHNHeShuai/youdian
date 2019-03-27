package com.youdian.bean;

/**
 * @author hs
 * @date 2019/3/3 - 10:57
 */
public class Company {

    private int id;
    private String linian;
    private String jianjie;
    private String jiazhiguan;
    private String kouhao;
    private String historyimage;
    private String history;
    private String telephone;
    private String email;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address
            ;



    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getLinian() {
        return linian;
    }

    public void setLinian(String linian) {
        this.linian = linian;
    }

    public String getJiazhiguan() {
        return jiazhiguan;
    }

    public void setJiazhiguan(String jiazhiguan) {
        this.jiazhiguan = jiazhiguan;
    }

    public String getKouhao() {
        return kouhao;
    }

    public void setKouhao(String kouhao) {
        this.kouhao = kouhao;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getHistoryimage() {
        return historyimage;
    }

    public void setHistoryimage(String historyimage) {

        this.historyimage = historyimage;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", linian='" + linian + '\'' +
                ", jianjie='" + jianjie + '\'' +
                ", jiazhiguan='" + jiazhiguan + '\'' +
                ", kouhao='" + kouhao + '\'' +
                ", historyimage='" + historyimage + '\'' +
                ", history='" + history + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
