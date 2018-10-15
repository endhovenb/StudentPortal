package nl.endhoven.bart.studentportal;

import android.os.Parcel;
import android.os.Parcelable;

public class PortalItem implements Parcelable {

    private String title;
    private String url;

    public PortalItem(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.url);
    }

    protected PortalItem(Parcel in) {
        this.title = in.readString();
        this.url = in.readString();
    }

    public static final Creator<PortalItem> CREATOR = new Creator<PortalItem>() {
        @Override
        public PortalItem createFromParcel(Parcel source) {
            return new PortalItem(source);
        }

        @Override
        public PortalItem[] newArray(int size) {
            return new PortalItem[size];
        }
    };
}
