package com.example.practice24.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmailServiceTest {
    private EmailService emailService;
    @MockBean
    private JavaMailSender emailSender;
    @Captor
    private ArgumentCaptor<SimpleMailMessage> captor;

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Test
    public void sendValidEmail() {
        String subject = "Test";
        String text = "Text";
        emailService.sendMail(subject, text);

        verify(emailSender, times(1))
                .send(ArgumentMatchers.any(SimpleMailMessage.class));
        verify(emailSender, times(1))
                .send(captor.capture());

        SimpleMailMessage actual = captor.getValue();
        assertEquals(subject, actual.getSubject());
        assertEquals(text, actual.getText());
    }
}
