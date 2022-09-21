package ru.job4j.weather.repository;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Repository;
import ru.job4j.weather.domain.Weather;

import java.util.*;
import java.util.stream.Stream;

@Repository
public class WeatherRepository {
    private final Map<Integer, Weather> weathers = new HashMap<>();

    {
        weathers.put(1, Weather.of(1, "Msc", 20));
        weathers.put(2, Weather.of(2, "Spb", 15));
        weathers.put(3, Weather.of(3, "Bryansk", 25));
        weathers.put(4, Weather.of(4, "Smolensk", 15));
        weathers.put(5, Weather.of(5, "Kiev", 15));
        weathers.put(6, Weather.of(6, "Minsk", 15));
    }

    public List<Weather> findAll() {
        return new ArrayList<>(weathers.values());
    }

    public List<Weather> cityGreatThen(int temp) {
        return weathers.values().stream().filter(t -> t.getTemperature() > temp).toList();
    }

    public Weather hottest() {
        return weathers
                .values()
                .stream()
                .max(Comparator.comparingInt(Weather::getTemperature))
                .orElseThrow(() -> new NoSuchElementException("Hottest weather not found"));
    }

    public Weather findById(int id) {
        return weathers.get(id);
    }
}
