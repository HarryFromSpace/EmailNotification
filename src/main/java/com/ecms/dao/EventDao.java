package com.ecms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecms.model.Event;

@Repository
public interface EventDao extends JpaRepository<Event, Integer>
{

}
