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
public class Subscription extends BaseEntityId {

    // название тарифа
    @Column(name = "name_tariff")
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

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    // нужен ли HASHCODE ??? столкнулся с такой штукой как baseentity
    // у него Id общий для всех сущностей а мне нужно переопределить hashcode id


}
