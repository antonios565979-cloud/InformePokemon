package pokemon.services;

import pokemon.models.Pokemon;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private String fileName = "informe_pokemon.txt";

    public List<Pokemon> cargarPokemons(String path) {
        ObjectMapper mapper = new ObjectMapper();
        List<Pokemon> pokemons = new ArrayList<>();

        try {
            pokemons = mapper.readValue(new File(path), new TypeReference<List<Pokemon>>() {
            });
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return pokemons;
    }

    public void guardarPokemons(String informe) {
        try (var bfr = new BufferedWriter(new FileWriter(fileName, StandardCharsets.UTF_8))) {
            bfr.write(informe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}