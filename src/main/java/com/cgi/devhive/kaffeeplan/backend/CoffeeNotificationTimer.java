package com.cgi.devhive.kaffeeplan.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CoffeeNotificationTimer {

  private static final Logger log = LoggerFactory.getLogger(CoffeeNotificationTimer.class);

  @Autowired
  public JavaMailSender emailSender;

  //  @Scheduled(fixedRate = 5000) // every 5 seconds for testing purposes
  @Scheduled(cron = "0 0 12 * * WED") // every wednesday at 12
  public void notifyMembers() {
    log.info("Timer started about to notify the member about the task to do");

    String eMailOfNextUser = getNextUser();
    notifyUser(eMailOfNextUser);
  }

  private String getNextUser() {
    return "benjamin.koehler@cgi.com";
  }

  private void notifyUser(String eMail) {
    if (eMail != null) {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(eMail);
      message.setSubject("Sie haben am Freitag Kaffeedienst");
      message.setText("Mach ma");
      emailSender.send(message);
    }
  }
}
