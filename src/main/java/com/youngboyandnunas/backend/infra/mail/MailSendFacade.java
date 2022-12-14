package com.youngboyandnunas.backend.infra.mail;

import com.youngboyandnunas.backend.global.exception.ErrorCode;
import com.youngboyandnunas.backend.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
@RequiredArgsConstructor
public class MailSendFacade {

    private final JavaMailSender mailSender;
    private final MailProperties mailProperties;

    public void sendHtmlMail(String toAddress, String title, String content) {
        try {
            sendMail(toAddress, title, content, true);
        } catch (Exception e) {
            throw new GlobalException(ErrorCode.NOT_FOUND_ERROR);
        }
    }

    private void sendMail(String toAddress, String title, String content, boolean isHtml) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, false, "UTF-8");

        messageHelper.setTo(toAddress);
        messageHelper.setFrom(mailProperties.getFromAddress());
        messageHelper.setSubject(title);

        messageHelper.setText(content, isHtml);
        mailSender.send(message);
    }

}
