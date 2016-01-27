package com.example.DailySelfie;

import android.graphics.Bitmap;

/**
 * Created by ramyashenoy on 1/27/16.
 */
public class Selfie {
    String label;
    Bitmap image;

    public Selfie(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
