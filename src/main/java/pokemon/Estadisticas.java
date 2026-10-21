package pokemon;

import pokemon.models.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Estadisticas {

    private List<Pokemon> pokemons;

    public Estadisticas(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int totalPokemons() {
        return pokemons.size();
    }

    public double nivelMedio() {
        int total = 0;

        for (Pokemon pokemon : pokemons) {
            total += pokemon.nivel();
        }

        return (double) total / pokemons.size();
    }

    public double psMedios() {
        int total = 0;

        for (Pokemon pokemon : pokemons) {
            total += pokemon.ps();
        }

        return (double) total / pokemons.size();
    }

    public String mayorNivel() {
        int mayor = 0;
        String pokemonMayorNivel = "";

        for (Pokemon pokemon : pokemons) {
            if (pokemon.nivel() > mayor) {
                mayor = pokemon.nivel();
                pokemonMayorNivel = pokemon.nombre();
            }
        }
        return pokemonMayorNivel + " (Nivel " + mayor + ")";
    }

    public String mayorPS() {
        int mayor = 0;
        String pokemonMasPS = "";

        for (Pokemon pokemon : pokemons) {
            if (pokemon.ps() > mayor) {
                mayor = pokemon.ps();
                pokemonMasPS = pokemon.nombre();
            }
        }
        return pokemonMasPS + " (PS " + mayor + ")";
    }

    public HashMap<String, Integer> totalTipo() {
        HashMap<String, Integer> mapTipo = new HashMap<>();

        for (Pokemon pokemon : pokemons) {
            String tipo = pokemon.tipo();

            if (mapTipo.containsKey(tipo)) {
                mapTipo.put(tipo, mapTipo.get(tipo) + 1);
            } else {
                mapTipo.put(tipo, 1);
            }
        }

        return mapTipo;
    }

    public HashMap<String, List<String>> pokemonPorTipo() {
        HashMap<String, List<String>> mapTipo = new HashMap<>();

        for (Pokemon pokemon : pokemons) {
            String tipo = pokemon.tipo();

            if (!mapTipo.containsKey(tipo)) {
                mapTipo.put(tipo, new ArrayList<>());
            }

            mapTipo.get(tipo).add(pokemon.nombre());
        }

        return mapTipo;
    }
}