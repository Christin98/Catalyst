package com.thecatalyst.catalyst.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TechDatum {
//    @SerializedName("createdAt")
//    @Expose
//    private Integer createdAt;
//    @SerializedName("updatedAt")
//    @Expose
//    private Integer updatedAt;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

//    public Integer getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Integer createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Integer getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Integer updatedAt) {
//        this.updatedAt = updatedAt;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
