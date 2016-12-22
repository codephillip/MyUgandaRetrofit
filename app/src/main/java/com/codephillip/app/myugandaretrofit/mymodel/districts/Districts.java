
package com.codephillip.app.myugandaretrofit.mymodel.districts;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Districts {

    @SerializedName("districts")
    @Expose
    private List<District> districts = null;

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

}
