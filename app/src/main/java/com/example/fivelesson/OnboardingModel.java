package com.example.fivelesson;

import android.widget.ImageView;
import android.widget.TextView;

public class OnboardingModel {
 private String title , Description;

    public OnboardingModel(String title, String description, int image) {
        this.title = title;
        Description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private int image;


}
