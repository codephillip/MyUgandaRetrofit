
package com.codephillip.app.myugandaretrofit.mymodel.feedbacks;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feedbacks {

    @SerializedName("feedback")
    @Expose
    private List<Feedback> feedback = null;

    public List<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

}
