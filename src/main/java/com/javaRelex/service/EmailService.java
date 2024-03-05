package com.javaRelex.service;

import com.javaRelex.mapper.CollectingProductStatisticMapper;
import com.javaRelex.repository.CollectingProductRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private CollectingProductRepository collectingProductRepository;
    @Autowired
    private CollectingProductStatisticMapper collectingProductStatisticMapper;
    @Autowired
    private TemplateEngine templateEngine;

    public void sendEmail(String to, String subject) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(to);
            helper.setSubject(subject);
            Context context = new Context();
            context.setVariable("items", collectingProductRepository.findAllByDate(new Date())
                    .stream().map(el -> collectingProductStatisticMapper.toDTO(el))
                    .collect(Collectors.toList()));
            String htmlContent = templateEngine.process("email-template", context);
            helper.setFrom("b100ming@yandex.ru");
            helper.setText(htmlContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
