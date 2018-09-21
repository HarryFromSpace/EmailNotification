package com.ecms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecms.model.Template;

@Repository
public interface TemplateDao extends JpaRepository<Template, Integer>
{
    @Query("select h from Template h where h.eventId = ?1")
    public Template getEventTemplate(Integer eventid);
}
