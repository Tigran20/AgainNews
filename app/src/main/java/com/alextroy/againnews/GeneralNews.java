
package com.alextroy.againnews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeneralNews {

    @SerializedName("response")
    @Expose
    private News response;

    public News getResponse() {
        return response;
    }

    public void setResponse(News response) {
        this.response = response;
    }

}
