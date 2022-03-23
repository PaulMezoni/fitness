package com.fitness.mvc.controller;

import com.fitness.entity.Subscription;
import com.fitness.mvc.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/subscription")
    public List<Subscription> getAllSubscription() {
        return subscriptionService.findByAll();
    }

    @GetMapping("/subscription/{id}")
    public Subscription getSubscriptionById(@PathVariable("id") long id) {
        return subscriptionService.getById(id);
    }

    @PostMapping(value = "/subscription")
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.saveSubscriptionMonth(subscription);
    }

    @PutMapping(value = "/subscription/{id}")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.saveSubscriptionMonth(subscription);
    }

    // нужно ли удалять абонемент из бд ?
    @DeleteMapping(value = "/subscription/{id}")
    public String deleteSubscription(@PathVariable("id") long id) {
        subscriptionService.deleteSubscription(id);
        return "Subscription with ID :" + id + " is deleted";
    }
}
