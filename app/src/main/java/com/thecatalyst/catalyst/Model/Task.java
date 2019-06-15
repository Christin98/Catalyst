package com.thecatalyst.catalyst.Model;

public class Task {
    private String tech;
    private String endDate;
    private String release;
    private String technology;
    private String teamMember;
    private String createdAt;
    private String tMember;
    private String parent_id;
    private String name;
    private String details;
    private String id;
    private String startDate;
    private String updatedAt;

    public Task(String tech,String endDate,String release,String technology,String teamMember,String createdAt,String tMember,String parent_id,String name,String details, String id,String startDate,String updatedAt)
    {
        this.tech = tech;
        this.endDate = endDate;
        this.release = release;
        this.technology = technology;
        this.teamMember = teamMember;
        this.createdAt = createdAt;
        this.tMember = tMember;
        this.parent_id = parent_id;
        this.name = name;
        this.details = details;
        this.id = id;
        this.startDate = startDate;
        this.updatedAt = updatedAt;
    }

    public String getTech ()
    {
        return tech;
    }

    public void setTech (String tech)
    {
        this.tech = tech;
    }

    public String getEndDate ()
    {
        return endDate;
    }

    public void setEndDate (String endDate)
    {
        this.endDate = endDate;
    }

    public String getRelease ()
    {
        return release;
    }

    public void setRelease (String release)
    {
        this.release = release;
    }

    public String getTechnology ()
    {
        return technology;
    }

    public void setTechnology (String technology)
    {
        this.technology = technology;
    }

    public String getTeamMember ()
    {
        return teamMember;
    }

    public void setTeamMember (String teamMember)
    {
        this.teamMember = teamMember;
    }

    public String getCreatedAt ()
    {
        return createdAt;
    }

    public void setCreatedAt (String createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getTMember ()
    {
        return tMember;
    }

    public void setTMember (String tMember)
    {
        this.tMember = tMember;
    }

    public String getParent_id ()
    {
        return parent_id;
    }

    public void setParent_id (String parent_id)
    {
        this.parent_id = parent_id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDetails ()
    {
        return details;
    }

    public void setDetails (String details)
    {
        this.details = details;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getStartDate ()
    {
        return startDate;
    }

    public void setStartDate (String startDate)
    {
        this.startDate = startDate;
    }

    public String getUpdatedAt ()
    {
        return updatedAt;
    }

    public void setUpdatedAt (String updatedAt)
    {
        this.updatedAt = updatedAt;
    }
}
