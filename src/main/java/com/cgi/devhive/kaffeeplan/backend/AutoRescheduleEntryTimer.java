package com.cgi.devhive.kaffeeplan.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AutoRescheduleEntryTimer {

  private static final Logger log = LoggerFactory.getLogger(AutoRescheduleEntryTimer.class);

  @Autowired
  WeekRepository weeks;

  //    @Scheduled(fixedRate = 5000) // every 5 seconds for testing purposes
  @Scheduled(cron = "0 0 12 * * SAT") // every saturday at 12
  public void rescheduleEntry() {
    log.info("Timer for scheduling the user after cleaning up started");

    Optional<KaffeeplanEntry> entry = getNextUser();
    entry.ifPresent(this::rescheduleUser);
  }

  private void rescheduleUser(KaffeeplanEntry entry) {
    // TODO: code logic
  }

  private Optional<KaffeeplanEntry> getNextUser() {
    int year = YearWeekSequenceGenerator.getCurrentYearAndWeek()[0];
    int week = YearWeekSequenceGenerator.getCurrentYearAndWeek()[1];
    String weekId = String.format("%04d%02d", year, week);

    log.info("searching for week: {}", weekId);
    Optional<KaffeeplanEntry> entry = weeks.findById(weekId);
    return entry;
  }
}
