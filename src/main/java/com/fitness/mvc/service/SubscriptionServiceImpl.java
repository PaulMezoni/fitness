package com.fitness.mvc.service;

import com.fitness.entity.Subscription;
import com.fitness.mvc.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class SubscriptionServiceImpl implements SubscriptionService {
    // абонементы
    // на один месяц
    private static final int subscriptionMonth = 31;
    // на пол года
    private static final int subscriptionSixMonths = 180;
    // на год
    private static final int subscriptionForYear = 365;

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription getById(Long id) {
        return subscriptionRepository.getById(id);
    }

    @Override
    public List<Subscription> findByAll() {
        return subscriptionRepository.findAll();
    }

    // сохранить абонемент с датой начала на 31 день
    @Override
    public Subscription saveSubscription(Subscription subscription) {
        subscription.setStartDateTime(LocalDateTime.now());
        LocalDateTime startDateTime = subscription.getStartDateTime();
        subscription.setEndDateTime(startDateTime.plusDays(subscriptionMonth));
        return subscriptionRepository.save(subscription);
    }

    // проверка оставшихся дней для посещения зала
    @Override
    public Subscription checkUpdateDateTime(Subscription subscription) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end = subscription.getEndDateTime();
        long difference = ChronoUnit.DAYS.between(now, end);
        if (difference > 0) {
            subscription.setRemainingNumberOfDays(difference);
        } else {
            System.out.println(" посещения в зале закончились ");
        }
        return subscriptionRepository.save(subscription);
    }
}
