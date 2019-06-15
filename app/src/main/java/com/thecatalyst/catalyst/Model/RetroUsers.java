package com.thecatalyst.catalyst.Model;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RetroUsers {

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
}
