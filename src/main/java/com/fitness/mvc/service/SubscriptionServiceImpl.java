package com.fitness.mvc.service;

import com.fitness.entity.Subscription;
import com.fitness.mvc.repository.SubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Slf4j
@Transactional
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

    // сохранить абонемент на 31 день
    @Override
    public Subscription saveSubscriptionMonth(Subscription subscription) {
        subscription.setStartDateTime(LocalDateTime.now());
        LocalDateTime startDateTime = subscription.getStartDateTime();
        subscription.setEndDateTime(startDateTime.plusDays(subscriptionMonth));
        return subscriptionRepository.save(subscription);
    }

    // сохранить абонемент на 6 месяцев
    @Override
    public Subscription saveSubscriptionSixMonths(Subscription subscription) {
        subscription.setStartDateTime(LocalDateTime.now());
        LocalDateTime startDateTime = subscription.getStartDateTime();
        subscription.setEndDateTime(startDateTime.plusDays(subscriptionSixMonths));
        return subscriptionRepository.save(subscription);
    }

    // проверка оставшихся посещений
    public Subscription checkingRemainingVisits(Subscription subscription) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end = subscription.getEndDateTime();
        long difference = ChronoUnit.DAYS.between(now, end);
        if (difference > 0) {
            log.info(" тренировки еще есть ");
        } else {
            log.info(" посещения в зале закончились ");
        }
        return subscription;
    }

    // нужен ли метод для удаления абонемента ?
    @Override
    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
