package com.cgi.devhive.kaffeeplan.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CoffeeNotificationTimer {

  private static final Logger log = LoggerFactory.getLogger(CoffeeNotificationTimer.class);

  //@Scheduled(fixedRate = 5000) every 5 seconds for testing purposes
  @Scheduled(cron = "0 0 12 * * WED") // every wednesday at 12
  public void notifyMembers() {
    log.info("Timer started about to notify the member about the task to do");
  }
}
