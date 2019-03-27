package com.youdian.bean;

/**
 * @author hs
 * @date 2019/3/3 - 11:16
 */
public class Zhaopin {
    private int id;
    private String title;
    private String job;
    private String createtime;
    private String task;
    private String must;

    public String getMust() {
        return must;
    }

    public void setMust(String must) {
        this.must = must;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}
