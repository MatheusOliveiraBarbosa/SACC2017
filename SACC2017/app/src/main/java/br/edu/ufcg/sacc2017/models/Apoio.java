package br.edu.ufcg.sacc2017.models;

import android.graphics.drawable.Icon;
import android.widget.ImageView;

/**
 * Created by mathe on 26/05/2017.
 */

public class Apoio {

    private String title;
    private String description;
    private ImageView image;

    public Apoio(String title, String description, ImageView image){
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public Apoio(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
