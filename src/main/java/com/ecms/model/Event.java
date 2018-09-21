package com.ecms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Event
{
    @Id
    @Column(name = "event_id")
    private Integer eventId;
    @Column(name = "event_name")
    private String eventName;


    public Event()
    {
        super();
    }


    public Event(Integer eventId, String eventName)
    {
        super();
        this.eventId = eventId;
        this.eventName = eventName;
    }


    public Integer getEventId()
    {
        return eventId;
    }


    public void setEventId(Integer eventId)
    {
        this.eventId = eventId;
    }


    public String getEventName()
    {
        return eventName;
    }


    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }


    @Override
    public String toString()
    {
        return "Event [eventId=" + eventId + ", eventName=" + eventName + "]";
    }

}
