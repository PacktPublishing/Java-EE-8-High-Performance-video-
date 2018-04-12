package com.wordpress.abhirockzz.javaee8.jaxrs;

import java.util.Random;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("cabs")
public class CabBookingResource {

    @Resource
    ManagedExecutorService mes;

    @GET
    @Path("{id}")
    public CompletionStage<String> getCab(@PathParam("id") final String name) {
        System.out.println("HTTP request handled by thread " + Thread.currentThread().getName());

        final CompletableFuture<Boolean> validateUserTask = new CompletableFuture<>();

        CompletableFuture<String> searchDriverTask = validateUserTask.thenComposeAsync(
                new Function<Boolean, CompletionStage<String>>() {
            @Override
            public CompletionStage<String> apply(Boolean t) {

                System.out.println("User validated ? " + t);
                return CompletableFuture.supplyAsync(() -> searchDriver(), mes);
            }
        }, mes);
        final CompletableFuture<String> notifyUserTask = searchDriverTask.thenApplyAsync(
                (driver) -> notifyUser(driver), mes);

        mes.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    validateUserTask.complete(validateUser(name));
                } catch (Exception ex) {
                    Logger.getLogger(CabBookingResource.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        return notifyUserTask;
    }

    boolean validateUser(String id) {
        System.out.println("searchDriverTask handled by thread " + Thread.currentThread().getName());
        System.out.println("validating user " + id);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(CabBookingResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    String searchDriver() {
        System.out.println("searchDriverTask handled by thread " + Thread.currentThread().getName());

        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(CabBookingResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "john doe";
    }

    String notifyUser(String info) {
        System.out.println("searchDriverTask handled by thread " + Thread.currentThread().getName());

        return "Your driver is " + info + " and the OTP is " + (new Random().nextInt(999) + 1000);
    }


}
