package com.xchangeapp.notificationservice.email;

import com.xchangeapp.notificationservice.email.freemarker.FreemarkerManager;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
@Slf4j
public class Email {

    private final JavaMailSender javaMailSender;
    private final FreemarkerManager freemarkerManager;

    @Value("${email.subject}")
    private String subject;

    @Value("${email.from}")
    private String from;

    @Value("${email.to}")
    private String[] toAddresses;

    @Async
    public void sendEmail(String template, Object data) {
        final MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            final MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setSubject(subject + " " + LocalDate.now().format(DateTimeFormatter.ISO_DATE));
            messageHelper.setText(freemarkerManager.render(template, data), true);
            messageHelper.setFrom(from);
            messageHelper.setTo(toAddresses);

            javaMailSender.send(messageHelper.getMimeMessage());
            
            log.info("Email sent to {}", StringUtils.join(toAddresses, ","));
        } catch (MessagingException e) {
            log.error("Email exception:", e);
        }
    }

}
