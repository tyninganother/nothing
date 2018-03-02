package com.tyning.nothing.util.beans;

import java.io.Serializable;

public class Teacher implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args){
        String repayed = "true";
        System.out.println(repayed.trim().toLowerCase().equals("false") && repayed.trim().toLowerCase().equals("true"));
    }
}
