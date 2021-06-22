package com.example.fivelesson;

import java.io.Serializable;

public class TaskModel implements Serializable {
    String title;
    String descrption;

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public TaskModel(String title, String descrption) {
        this.title = title;
        this.descrption = descrption;
    }

    public String getTxttitle() {
        return title;
    }

    public void setTxttitle(String txttitle) {
        this.title = txttitle;
    }
}
