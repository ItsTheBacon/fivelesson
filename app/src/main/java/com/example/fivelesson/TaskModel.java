package com.example.fivelesson;

import android.widget.TextView;

public class TaskModel {
    TextView txttitle;


    public TaskModel(TextView txttitle) {
        this.txttitle = txttitle;
    }

    public TextView getTxttitle() {
        return txttitle;
    }

    public void setTxttitle(TextView txttitle) {
        this.txttitle = txttitle;
    }
}
