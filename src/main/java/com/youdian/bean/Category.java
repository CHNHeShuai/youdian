package com.youdian.bean;

import java.util.List;

/**
 * @author hs
 * @date 2019/2/28 - 20:50
 */
public class Category {

    private int id;
    private String cname;

    private List<Example> examples;

    public List<Example> getExamples() {
        return examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", examples=" + examples +
                '}';
    }
}
