package com.example.email.service;

import com.example.email.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final String DEFAULT_SUBJECT = "New website enquiry";

    private final JavaMailSender mailSender;
    private final String fromAddress;

    public EmailService(JavaMailSender mailSender,
                        @Value("${app.mail.from}") String fromAddress) {
        this.mailSender = mailSender;
        this.fromAddress = fromAddress;
    }

    public void sendEmail(EmailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromAddress);
        message.setTo(request.to());
        message.setSubject(resolveSubject(request));
        message.setText(buildBody(request));

        mailSender.send(message);
    }

    private String resolveSubject(EmailRequest request) {
        if (request.subject() != null && !request.subject().isBlank()) {
            return request.subject();
        }
        String name = request.contactName();
        return name == null || name.isBlank()
                ? DEFAULT_SUBJECT
                : DEFAULT_SUBJECT + " from " + name;
    }

    private String buildBody(EmailRequest request) {
        return """
                Hi Team,

                You have a new enquiry submitted via the website:

                Name: %s
                Email: %s
                Phone: %s
                Company: %s

                Message:
                %s

                Please follow up with the requester as soon as possible.

                Thanks,
                Website Bot
                """.formatted(
                optionalValue(request.contactName()),
                optionalValue(request.contactEmail()),
                optionalValue(request.contactPhone()),
                optionalValue(request.company()),
                request.message()
        );
    }

    private String optionalValue(String value) {
        return value == null || value.isBlank() ? "-" : value;
    }
}

