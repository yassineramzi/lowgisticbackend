package com.lowgistic.management.service;

public interface EmailToBeSentService
{
    void create(final String objetMail, final String email, final String login, final String password, final String nomSociete);
}
