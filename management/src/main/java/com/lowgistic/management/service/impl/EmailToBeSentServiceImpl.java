package com.lowgistic.management.service.impl;

import com.lowgistic.management.domain.EmailToBeSent;
import com.lowgistic.management.enums.EStatus;
import com.lowgistic.management.repository.EmailToBeSentRepository;
import com.lowgistic.management.service.EmailToBeSentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailToBeSentServiceImpl implements EmailToBeSentService {
    private final Logger log = LoggerFactory.getLogger(EmailToBeSentServiceImpl.class);

    private final EmailToBeSentRepository emailToBeSentRepository;

    @Override
    public void create(final String objetMail, final String email, final String login, final String password, final String nomSociete) {
        log.info("Enregistrement du mail a envoyé à : {}, objet : {}, pour la société : {}", email, objetMail, nomSociete);
        EmailToBeSent emailToBeSent = new EmailToBeSent();
        emailToBeSent.setObjet(objetMail);
        emailToBeSent.setEmail(email);
        emailToBeSent.setLogin(login);
        emailToBeSent.setPassword(password);
        emailToBeSent.setNomSociete(nomSociete);
        emailToBeSent.setStatus(EStatus.NOT_SENT);
        this.emailToBeSentRepository.save(emailToBeSent);
    }
}
