package com.javatechie.dto;

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
public class CollectingProductDto {
    private int theRateOfCollection;
    private int collecting;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String name;
    private String unitOfMeasurement;
}
