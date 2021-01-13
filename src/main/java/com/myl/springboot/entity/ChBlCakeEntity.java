package com.myl.springboot.entity;

public class ChBlCakeEntity {
    private String personId;
    private int cakeDate;
    private String cakeId;
    private int state;
    private String taskId;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public int getCakeDate() {
        return cakeDate;
    }

    public void setCakeDate(int cakeDate) {
        this.cakeDate = cakeDate;
    }

    public String getCakeId() {
        return cakeId;
    }

    public void setCakeId(String cakeId) {
        this.cakeId = cakeId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
