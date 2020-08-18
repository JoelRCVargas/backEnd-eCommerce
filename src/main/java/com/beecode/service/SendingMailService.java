package com.beecode.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.beecode.entity.MailProperties;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class SendingMailService {
	
	private final MailProperties mailProperties;
	private final Configuration templates;
	
	@Autowired
	public SendingMailService(MailProperties mailProperties, Configuration templates) {
		this.mailProperties = mailProperties;
		this.templates = templates;
	}
	
	public boolean sendForgotPasswordMail(String toMail, String verificationCode, String link, String nameuser) {
		String subject = "Solicitud de restablecimiento de contraseña";
		String body = "";
		try {
			Template t = templates.getTemplate("forgot-password.ftl");
			Map<String, String> map = new HashMap<>();
			map.put("VERIFICATION_URL", link + verificationCode);
			map.put("NAME_USER", nameuser);
			body = FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
		}
		return senMail(toMail,subject,body);
	}
	
	public boolean sendVerificationMail(String toMail, String verificationCode) {
		String subject = "Porfavor verifique su correo electronico";
		String body = "";
		try {
			Template t = templates.getTemplate("email-verification.ftl");
			Map<String, String> map = new HashMap<>();
			map.put("VERIFICATION_URL", mailProperties.getVerificationapi() + verificationCode);
			body = FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
		}
		return senMail(toMail,subject,body);
	}

	private boolean senMail(String toMail, String subject, String body) {
		try {
            Properties props = System.getProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.port", mailProperties.getSmtp().getPort());
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);

            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(mailProperties.getFrom(), mailProperties.getFromName()));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
            msg.setSubject(subject);
            msg.setContent(body, "text/html; charset=utf-8");

            Transport transport = session.getTransport();
            transport.connect(mailProperties.getSmtp().getHost(), mailProperties.getSmtp().getUsername(),
            		mailProperties.getSmtp().getPassword());
            transport.sendMessage(msg, msg.getAllRecipients());
            return true;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return false;
	}
	
	
}
