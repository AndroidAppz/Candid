package com.becandid.candid.models;

public class GroupNameCheck {
    String error;
    int group_id;
    String group_name;
    boolean success;

    public String getGroupName() {
        return this.group_name;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getError() {
        return this.error;
    }

    public int getGroupId() {
        return this.group_id;
    }
}
