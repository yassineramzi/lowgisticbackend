package com.lowgistic.email.service.impl;

import com.lowgistic.email.service.EmailService;
import com.lowgistic.email.service.dto.UtilisateurDto;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {
    private final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
    private final Configuration configuration;
    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    public EmailServiceImpl(Configuration configuration, JavaMailSender javaMailSender){
        this.configuration = configuration;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(UtilisateurDto utilisateurDto) throws IOException, TemplateException, MessagingException {
        log.info("Send email to user : "+utilisateurDto.getEmail());
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom(this.from);
        helper.setSubject("Welcome to Lowgistic");
        helper.setTo(utilisateurDto.getEmail());
        String emailContent = getEmailContent(utilisateurDto);
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }

    private String getEmailContent(UtilisateurDto utilisateurDto) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("utilisateur", utilisateurDto);
        configuration.getTemplate("creation_compte.ftlh").process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
