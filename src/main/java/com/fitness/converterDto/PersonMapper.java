package com.fitness.converterDto;

import com.fitness.dto.PersonDto;
import com.fitness.entity.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {
    PersonDto personToDto(Person person);
}
