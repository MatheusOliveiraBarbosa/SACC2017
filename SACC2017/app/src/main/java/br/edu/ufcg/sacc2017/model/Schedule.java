package br.edu.ufcg.sacc2017.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mathe on 28/05/2017.
 */

public class Schedule implements Parcelable {

    private String name;
    private String time;
    private String presenter;
    private String description;
    private String logo;
    private String site;

    public Schedule(){}


    protected Schedule(Parcel in) {
        name = in.readString();
        time = in.readString();
        presenter = in.readString();
        description = in.readString();
        logo = in.readString();
        site = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(time);
        dest.writeString(presenter);
        dest.writeString(description);
        dest.writeString(logo);
        dest.writeString(site);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Schedule> CREATOR = new Creator<Schedule>() {
        @Override
        public Schedule createFromParcel(Parcel in) {
            return new Schedule(in);
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }
}
