package com.thecatalyst.catalyst.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tmember {
    @SerializedName("tMember")
    @Expose
    private List<Object> tMember = null;
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
    @SerializedName("teamMember")
    @Expose
    private String teamMember;
    @SerializedName("finished")
    @Expose
    private Integer finished;

    public List<Object> getTMember() {
        return tMember;
    }

    public void setTMember(List<Object> tMember) {
        this.tMember = tMember;
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

    public String getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(String teamMember) {
        this.teamMember = teamMember;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

}
