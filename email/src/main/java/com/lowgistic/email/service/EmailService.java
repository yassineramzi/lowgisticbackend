package com.lowgistic.email.service;

import com.lowgistic.email.service.dto.UtilisateurDto;

import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {
    void sendEmail(UtilisateurDto utilisateurDto) throws MessagingException, IOException, TemplateException, javax.mail.MessagingException;
}
