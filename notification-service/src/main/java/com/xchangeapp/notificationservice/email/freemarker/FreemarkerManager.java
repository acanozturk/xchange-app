package com.xchangeapp.notificationservice.email.freemarker;

import freemarker.template.Configuration;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Component
@AllArgsConstructor
@Slf4j
public class FreemarkerManager {
    
    private final Configuration configuration;

    public String render(String template, Object data) {
        final StringBuilder content = new StringBuilder();
        
        try {
            content.append(
                    FreeMarkerTemplateUtils.processTemplateIntoString(
                            configuration.getTemplate(template),
                            data
                    )
            );
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return content.toString();
    }
    
}
