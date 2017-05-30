package br.com.ufcg.sacc2017.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by easyo on 28/05/2017.
 */

public class TeamMember implements Parcelable {

    private String name;
    private String role;
    private String description;
    private String photo;

    public TeamMember() {
    }

    protected TeamMember(Parcel in) {
        name = in.readString();
        role = in.readString();
        description = in.readString();
        photo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(role);
        dest.writeString(description);
        dest.writeString(photo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TeamMember> CREATOR = new Creator<TeamMember>() {
        @Override
        public TeamMember createFromParcel(Parcel in) {
            return new TeamMember(in);
        }

        @Override
        public TeamMember[] newArray(int size) {
            return new TeamMember[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
