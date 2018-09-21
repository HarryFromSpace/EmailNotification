package com.ecms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class User
{
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "event_id")
    private Integer eventId;
    private String username;
    private String email;


    public User()
    {
        super();
    }


    public User(Integer userId, Integer eventId, String username, String email)
    {
        super();
        this.userId = userId;
        this.eventId = eventId;
        this.username = username;
        this.email = email;
    }


    public Integer getUserId()
    {
        return userId;
    }


    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }


    public Integer getEventId()
    {
        return eventId;
    }


    public void setEventId(Integer eventId)
    {
        this.eventId = eventId;
    }


    public String getUsername()
    {
        return username;
    }


    public void setUsername(String username)
    {
        this.username = username;
    }


    public String getEmail()
    {
        return email;
    }


    public void setEmail(String email)
    {
        this.email = email;
    }


    @Override
    public String toString()
    {
        return "User [userId=" + userId + ", eventId=" + eventId + ", name=" + username + ", email=" + email + "]";
    }

}
