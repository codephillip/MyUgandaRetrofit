
package com.codephillip.app.myugandaretrofit.mymodel.chapters;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chapters {

    @SerializedName("chapters")
    @Expose
    private List<Chapter> chapters = null;

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

}
