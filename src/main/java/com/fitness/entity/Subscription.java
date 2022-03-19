package com.fitness.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "subscription")
@NoArgsConstructor
//Абонемент (подписка)
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nameTariff;
    // Стоимость пакета
    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;
    // Время начала действия пакета
    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;
    // Время завершения действия пакета
    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;
    // Оставшееся количество тренировок
    @Column(name = "remaining_number_of_days", nullable = false)
    private long remainingNumberOfDays;

//    // количество посещений
//    int countOfVisit;
//    // остаток визита
//    int restOfVisit;

    boolean isLimited;
}
