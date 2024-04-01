package dev.mritunjay.springcacheredis.service;

import dev.mritunjay.springcacheredis.model.Car;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduleTasks {

    private CarService carService;

    public ScheduleTasks(CarService carService) {
        this.carService = carService;
    }

    @Scheduled(cron = "0 * * * * *" )
    public void execute(){
        carService.deleteAll();
    }
}

/*

 Cron Scheduling format -
     *    *    *    *     *     *
    sec  min  hour day  Month dayofweek


  0 0 9 * * * -> everyday at 9 AM
  0 30 9 * * *  -> everyday at 9:30 AM
  0 30 9 * * 1 -> every monday[1] at 9:30 AM


  0 * * * * * -> run every minute post deployment
  * * * * * * -> run every second post deployment
  0 0 * * * * -> run every hour post deployment
 */
