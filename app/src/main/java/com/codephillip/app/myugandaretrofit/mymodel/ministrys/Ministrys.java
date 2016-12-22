
package com.codephillip.app.myugandaretrofit.mymodel.ministrys;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ministrys {

    @SerializedName("ministrys")
    @Expose
    private List<Ministry> ministrys = null;

    public List<Ministry> getMinistrys() {
        return ministrys;
    }

    public void setMinistrys(List<Ministry> ministrys) {
        this.ministrys = ministrys;
    }

}
