package com.angelectro.zt.service;

import com.angelectro.zt.Tasks.CheckingChanges;
import org.springframework.stereotype.Service;

import java.util.Timer;

/**
 * Created by Zahit Talipov on 13.10.2015.
 */
@Service
public class ServiceUpdateTimetable {

       public ServiceUpdateTimetable()
       {
           CheckingChanges changes= new CheckingChanges();
           Timer timer= new Timer();
           timer.schedule(changes,0,5*60*1000);
       }

}
