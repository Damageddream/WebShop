package com.webshop.shop.io;

import java.time.Duration;
import java.time.LocalDateTime;

public class OrderTimeTracker {
    private LocalDateTime startTracking;
    private LocalDateTime finishTracking;


    public void trackingStart(){
        startTracking = LocalDateTime.now();
    }
    public void trackingEnd(){
        finishTracking = LocalDateTime.now();
    }

    public void getOrderDuration(){
        Duration difference = Duration.between(startTracking, finishTracking);
        System.out.println("Time to make your order was: "+difference.toSeconds()+" seconds \uD83D\uDD66");
    }
}
