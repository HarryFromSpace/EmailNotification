package com.ecms.utils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.ecms.dao.TemplateDao;
import com.ecms.model.Event;
import com.ecms.model.Template;

@Component
public class TemplateUtility
{
    @Autowired
    private TemplateDao templateDao;
    @Autowired
    private SpringTemplateEngine templateEngine;


    public String removeExtension(String fileNameWithExt)
    {
        String fileNameWithOutExt = FilenameUtils.removeExtension(fileNameWithExt);
        return fileNameWithOutExt;
    }


    public Template getTemplate(Event event)
    {
        return templateDao.getEventTemplate(event.getEventId());
    }


    public String htmlThymleafTemplate(Event event)
    {
        Template template = getTemplate(event);
        String fileNameWithOutExt = removeExtension(template.getTemplateContent());
        Context context = new Context();
        String html = templateEngine.process(fileNameWithOutExt, context);
        return html;
    }


    public String gettemplateSubject(Event event)
    {
        Template template = getTemplate(event);
        return template.getSubject();
    }
}
