package com.cgi.devhive.kaffeeplan.backend;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CoffeeNotificationTimer {

  private static final Logger log = LoggerFactory.getLogger(CoffeeNotificationTimer.class);

  @Autowired
  public JavaMailSender emailSender;

  @Autowired
  WeekRepository weeks;

  //    @Scheduled(fixedRate = 5000) // every 5 seconds for testing purposes
  @Scheduled(cron = "0 0 12 * * WED") // every wednesday at 12
  public void notifyMembers() {
    log.info("Timer started about to notify the member about the task to do");

    Optional<KaffeeplanEntry> eMailOfNextUser = getNextUser();
    if (eMailOfNextUser.isPresent()) {
      notifyUser(eMailOfNextUser.get().getEmail());
    }
  }

  private Optional<KaffeeplanEntry> getNextUser() {
    int year = YearWeekSequenceGenerator.getCurrentYearAndWeek()[0];
    int week = YearWeekSequenceGenerator.getCurrentYearAndWeek()[1];
    String weekId = String.format("%04d%02d", year, week);

    log.info("searching for week: {}", weekId);
    Optional<KaffeeplanEntry> entry = weeks.findById(weekId);
    return entry;
  }

  private void notifyUser(String email) {
    if (Strings.isNotEmpty(email)) {
      log.info("sending email to {}", email);

      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(email);
      message.setSubject("Sie haben am Freitag Kaffeedienst");
      message.setText("Mach ma");
      emailSender.send(message);
    }
  }
}
