package com.fitness.mvc.service;

import com.fitness.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription getById(Long id);

    List<Subscription> findByAll();

    Subscription saveSubscriptionMonth(Subscription subscription);

    Subscription saveSubscriptionSixMonths(Subscription subscription);

    Subscription checkingRemainingVisits(Subscription subscription);

    void deleteSubscription(Long id);
}
