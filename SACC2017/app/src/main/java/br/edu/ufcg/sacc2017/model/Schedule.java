package br.edu.ufcg.sacc2017.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mathe on 28/05/2017.
 */

public class Schedule implements Parcelable {

    private String name;
    private String description;
    private String logo;
    private String site;

    public Schedule(){}

    protected Schedule (Parcel in){
        this.name = in.readString();
        this.description = in.readString();
        this.logo = in.readString();
        this.site = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.logo);
        dest.writeString(this.site);
    }

    public static final Creator<Schedule> CREATOR = new Creator<Schedule>() {
        @Override
        public Schedule createFromParcel(Parcel source) {
            return new Schedule(source);
        }

        @Override
        public Schedule[] newArray(int size) {
            return new Schedule[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
