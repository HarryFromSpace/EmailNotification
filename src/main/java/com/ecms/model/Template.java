package com.ecms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Template
{
    @Id
    @Column(name = "content_id")
    private Integer contentId;
    @Column(name = "event_id")
    private Integer eventId;
    @Column(name = "template_content")
    private String templateContent;
    private String subject;
    private int status;


    public Template()
    {
        super();
    }


    public Template(Integer contentId, Integer eventId, String templateContent, String subject, int status)
    {
        super();
        this.contentId = contentId;
        this.eventId = eventId;
        this.templateContent = templateContent;
        this.subject = subject;
        this.status = status;
    }


    public Integer getContentId()
    {
        return contentId;
    }


    public void setContentId(Integer contentId)
    {
        this.contentId = contentId;
    }


    public Integer getEventId()
    {
        return eventId;
    }


    public void setEventId(Integer eventId)
    {
        this.eventId = eventId;
    }


    public String getTemplateContent()
    {
        return templateContent;
    }


    public void setTemplateContent(String templateContent)
    {
        this.templateContent = templateContent;
    }


    public String getSubject()
    {
        return subject;
    }


    public void setSubject(String subject)
    {
        this.subject = subject;
    }


    public int getStatus()
    {
        return status;
    }


    public void setStatus(int status)
    {
        this.status = status;
    }


    @Override
    public String toString()
    {
        return "EventTemplate [contentId="
            + contentId + ", eventId=" + eventId + ", templateContent=" + templateContent
            + ", subject=" + subject + ", status=" + status + "]";
    }

}
