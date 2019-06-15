package com.thecatalyst.catalyst.Model;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RetroUsers {

<<<<<<< HEAD
    @SerializedName("task")
    @Expose
    private List<Task> task = new ArrayList<Task>();
//        @SerializedName("createdAt")
//        @Expose
//        private Integer createdAt;
//        @SerializedName("updatedAt")
//        @Expose
//        private Integer updatedAt;
//        @SerializedName("id")
//        @Expose
//        private Integer id;
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
//        @SerializedName("release")
//        @Expose
//        private String release;
//        @SerializedName("parent_id")
//        @Expose
//        private Object parentId;
//        @SerializedName("teamMember")
//        @Expose
//        private Object teamMember;
        @SerializedName("technology")
        @Expose
        private Technology technology;
//        @SerializedName("tMember")
//        @Expose
//        private Object tMember;
//        @SerializedName("tech")
//        @Expose
//        private Object tech;

//        public Integer getCreatedAt() {
//            return createdAt;
//        }
//
//        public void setCreatedAt(Integer createdAt) {
//            this.createdAt = createdAt;
//        }
//
//        public Integer getUpdatedAt() {
//            return updatedAt;
//        }
//
//        public void setUpdatedAt(Integer updatedAt) {
//            this.updatedAt = updatedAt;
//        }
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }

    public List<Task> getTask()
    {
        return task;
    }

    public void setTask(List<Task> task)
    {
        this.task = task;
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

//        public String getRelease() {
//            return release;
//        }
//
//        public void setRelease(String release) {
//            this.release = release;
//        }
//
//        public Object getParentId() {
//            return parentId;
//        }
//
//        public void setParentId(Object parentId) {
//            this.parentId = parentId;
//        }
//
//        public Object getTeamMember() {
//            return teamMember;
//        }
//
//        public void setTeamMember(Object teamMember) {
//            this.teamMember = teamMember;
//        }
//
        public Technology getTechnology() {
            return technology;
        }

        public void setTechnology(Technology technology) {
            this.technology = technology;

            Log.e("TAG", "setTechnology: "+technology);
        }
//
//        public Object getTMember() {
//            return tMember;
//        }
//
//        public void setTMember(Object tMember) {
//            this.tMember = tMember;
//        }
//
//        public Object getTech() {
//            return tech;
//        }
//
//        public void setTech(Object tech) {
//            this.tech = tech;
//        }

=======
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("messages")
    @Expose
    private String messages;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("techData")
    @Expose
    private List<TechDatum> techData = null;
    @SerializedName("teamData")
    @Expose
    private List<TeamDatum> teamData = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public List<TechDatum> getTechData() {
        return techData;
    }

    public void setTechData(List<TechDatum> techData) {
        this.techData = techData;
    }

    public List<TeamDatum> getTeamData() {
        return teamData;
    }

    public void setTeamData(List<TeamDatum> teamData) {
        this.teamData = teamData;
    }
>>>>>>> 1124fdd3ee1e5e3ccfd2f4049ec6cd750c80d1a3
}
