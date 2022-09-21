package ru.job4j.weather.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.job4j.weather.domain.Weather;
import ru.job4j.weather.repository.WeatherRepository;

@RequiredArgsConstructor
@Service
public class WeatherService {
    @NonNull
    private final WeatherRepository repository;

    public Mono<Weather> findById(Integer id) {
        return Mono.justOrEmpty(repository.findById(id));
    }

    public Flux<Weather> findAll() {
        return Flux.fromIterable(repository.findAll());
    }

    public Flux<Weather> cityGreatThen(int temp) {
        return Flux.fromIterable(repository.cityGreatThen(temp));
    }

    public Mono<Weather> hottest() {
        return Mono.justOrEmpty(repository.hottest());
    }
}
