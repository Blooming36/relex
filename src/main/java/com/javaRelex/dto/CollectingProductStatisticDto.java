package com.javaRelex.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CollectingProductStatisticDto {
    private String firstName;
    private String lastName;
    private String patronymic;
    private int theRateOfCollection;
    private int collecting;
    private String name;
    private String unitOfMeasurement;
    @Temporal(TemporalType.DATE)
    private Date date;
}
