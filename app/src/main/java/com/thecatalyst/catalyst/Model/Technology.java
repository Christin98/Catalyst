package com.thecatalyst.catalyst.Model;
<<<<<<< HEAD
=======

>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Technology {

<<<<<<< HEAD
    @SerializedName("tMember")
    @Expose
    private List<Object> tMember = null;
=======
    @SerializedName("tech")
    @Expose
    private List<Object> tech = null;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
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
<<<<<<< HEAD
    @SerializedName("teamMember")
    @Expose
    private String teamMember;

    public List<Object> getTMember() {
        return tMember;
    }

    public void setTMember(List<Object> tMember) {
        this.tMember = tMember;
=======
    @SerializedName("technology")
    @Expose
    private String technology;

    public List<Object> getTech() {
        return tech;
    }

    public void setTech(List<Object> tech) {
        this.tech = tech;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
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

<<<<<<< HEAD
    public String getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(String teamMember) {
        this.teamMember = teamMember;
=======
    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
    }

}