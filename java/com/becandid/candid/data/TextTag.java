package com.becandid.candid.data;

public class TextTag {
    public int endIndex;
    public int groupId;
    public int startIndex;

    public TextTag(int startIndex, int endIndex, int groupId) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.groupId = groupId;
    }

    public String toString() {
        return Integer.toString(this.groupId) + "," + Integer.toString(this.startIndex) + "," + Integer.toString(this.endIndex);
    }
}
