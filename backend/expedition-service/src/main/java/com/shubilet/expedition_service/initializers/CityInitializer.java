package com.shubilet.expedition_service.initializers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.shubilet.expedition_service.models.City;
import com.shubilet.expedition_service.repositories.CityRepository;

@Component
public class CityInitializer implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(CityInitializer.class);

    private final CityRepository cityRepository;

    // Constructor injection (if needed later)
    public CityInitializer(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * Initializes city-related data on application startup.
     * Currently empty.
     */
    @Override
    public void run(String... args) throws Exception {
       List<String> cities = List.of(
        "Agadir",
        "Al Hoceima",
        "Azilal",
        "Beni Mellal",
        "Berkane",
        "Boujdour",
        "Boulemane",
        "Casablanca",
        "Chefchaouen",
        "Chichaoua",
        "Dakhla",
        "El Jadida",
        "El Kelâa des Sraghna",
        "Errachidia",
        "Essaouira",
        "Fes",
        "Figuig",
        "Guelmim",
        "Ifrane",
        "Kenitra",
        "Khemisset",
        "Khenifra",
        "Khouribga",
        "Laayoune",
        "Larache",
        "Marrakech",
        "Meknes",
        "Midelt",
        "Mohammedia",
        "Nador",
        "Ouarzazate",
        "Oujda",
        "Rabat",
        "Safi",
        "Sale",
        "Settat",
        "Sidi Bennour",
        "Sidi Ifni",
        "Sidi Kacem",
        "Sidi Slimane",
        "Skhirat",
        "Tan-Tan",
        "Tangier",
        "Taounate",
        "Taroudant",
        "Tata",
        "Taza",
        "Tetouan",
        "Tinghir",
        "Tiznit",
        "Youssoufia",
        "Zagora"
);

        for (String cityName : cities) {
            if(!cityRepository.existsByName(cityName)) {
                City city = new City();
                city.setName(cityName);
                // Presumably save the city to the database here
                cityRepository.save(city);
                logger.info("Initialized city: {}", cityName);
            }
        }
    }
}
