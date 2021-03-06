package com.alextroy.againnews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {
    @SerializedName("trailText")
    @Expose
    private String trailText;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getTrailText() {
        return trailText;
    }

    public void setTrailText(String trailText) {
        this.trailText = trailText;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
