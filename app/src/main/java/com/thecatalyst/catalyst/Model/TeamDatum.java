package com.thecatalyst.catalyst.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamDatum {
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
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("userRole")
    @Expose
    private Integer userRole;
    @SerializedName("isActive")
    @Expose
    private Integer isActive;
    @SerializedName("skill")
    @Expose
    private Object skill;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Object getSkill() {
        return skill;
    }

    public void setSkill(Object skill) {
        this.skill = skill;
    }

}
