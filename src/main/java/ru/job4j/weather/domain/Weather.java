package ru.job4j.weather.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor(staticName = "of")
public class Weather {
    @EqualsAndHashCode.Include
    @NonNull
    @Positive(message = "Id is mandatory")
    private int id;
    @NonNull
    @NotBlank(message = "City name is mandatory")
    private String city;
    @NonNull
    private int temperature;
}
