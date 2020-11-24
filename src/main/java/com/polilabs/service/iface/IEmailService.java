package com.polilabs.service.iface;

public interface IEmailService {

    public void sendMail(String from, String to, String subject, String body);

}
