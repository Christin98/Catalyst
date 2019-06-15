package com.thecatalyst.catalyst.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Technology {

    @SerializedName("tech")
    @Expose
    private List<Object> tech = null;
    @SerializedName("createdAt")
    @Expose
    private Integer createdAt;
    @SerializedName("updatedAt")
    @Expose
    private Integer updatedAt;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("projectId")
    @Expose
    private Integer projectId;
    @SerializedName("technology")
    @Expose
    private String technology;

    public List<Object> getTech() {
        return tech;
    }

    public void setTech(List<Object> tech) {
        this.tech = tech;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

}