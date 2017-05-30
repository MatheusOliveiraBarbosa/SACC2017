package br.com.ufcg.sacc2017.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by WitaloCarlos on 27/05/2017.
 */

public class SupportMember implements Parcelable {

    private String description;
    private String title;
    private String site;
    private int type;
    private String logo;

    public SupportMember() {
    }

    protected SupportMember(Parcel in) {
        description = in.readString();
        title = in.readString();
        site = in.readString();
        type = in.readInt();
        logo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(title);
        dest.writeString(site);
        dest.writeInt(type);
        dest.writeString(logo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SupportMember> CREATOR = new Creator<SupportMember>() {
        @Override
        public SupportMember createFromParcel(Parcel in) {
            return new SupportMember(in);
        }

        @Override
        public SupportMember[] newArray(int size) {
            return new SupportMember[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
