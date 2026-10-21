package pokemon;

import pokemon.models.Pokemon;
import pokemon.reports.Informe;
import pokemon.services.FileService;

import java.util.List;

public class Main {
    static void main() {

        FileService fs = new FileService();

        List<Pokemon> pokemons = fs.cargarPokemons("pokemon.json");

        Estadisticas estadisticas = new Estadisticas(pokemons);
        Informe informe = new Informe(estadisticas);

        fs.guardarPokemons(informe.informePokemon());

        System.out.println("Informe generado: informe_pokemon.txt");
    }
}