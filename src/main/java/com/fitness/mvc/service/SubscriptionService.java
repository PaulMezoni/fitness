package com.fitness.mvc.service;

import com.fitness.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription getById(Long id);

    List<Subscription> findByAll();

    Subscription saveSubscription(Subscription subscription);

    Subscription checkUpdateDateTime(Subscription subscription);

    void deleteSubscription(Long id);
}
