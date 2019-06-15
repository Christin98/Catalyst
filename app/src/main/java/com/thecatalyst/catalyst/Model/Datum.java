package com.thecatalyst.catalyst.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
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
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("release")
    @Expose
    private String release;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("completed")
    @Expose
    private Integer completed;
    @SerializedName("parent_id")
    @Expose
    private Integer parentId;
    @SerializedName("teamMember")
    @Expose
    private Object teamMember;
    @SerializedName("technology")
    @Expose
    private Object technology;
    @SerializedName("tMember")
    @Expose
    private Object tMember;
    @SerializedName("tech")
    @Expose
    private Object tech;
    @SerializedName("allTeamMembers")
    @Expose
    private String allTeamMembers;
    @SerializedName("allTechnology")
    @Expose
    private String allTechnology;

//    public Integer getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Integer createdAt) {
//        this.createdAt = createdAt;
//    }

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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Object getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(Object teamMember) {
        this.teamMember = teamMember;
    }

    public Object getTechnology() {
        return technology;
    }

    public void setTechnology(Object technology) {
        this.technology = technology;
    }

    public Object getTMember() {
        return tMember;
    }

    public void setTMember(Object tMember) {
        this.tMember = tMember;
    }

    public Object getTech() {
        return tech;
    }

    public void setTech(Object tech) {
        this.tech = tech;
    }

    public String getAllTeamMembers() {
        return allTeamMembers;
    }

    public void setAllTeamMembers(String allTeamMembers) {
        this.allTeamMembers = allTeamMembers;
    }

    public String getAllTechnology() {
        return allTechnology;
    }

    public void setAllTechnology(String allTechnology) {
        this.allTechnology = allTechnology;
    }

}
