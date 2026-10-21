package pokemon.reports;

import pokemon.Estadisticas;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Informe {

    private Estadisticas est;

    public Informe(Estadisticas est) {
        this.est = est;
    }

    public String informePokemon() {
        StringBuilder sb = new StringBuilder();

        sb.append("=========================\n");
        sb.append(" INFORME DE POKÉMON\n");
        sb.append("=========================\n\n");
        sb.append("Total de Pokémon: ").append(est.totalPokemons()).append("\n\n");
        sb.append(String.format(Locale.US, "Nivel medio: %.2f%n%n", est.nivelMedio()));
        sb.append(String.format(Locale.US, "PS medios: %.2f%n%n", est.psMedios()));
        sb.append("Pokémon con mayor nivel:\n");
        sb.append(est.mayorNivel()).append("\n\n");
        sb.append("Pokémon con más PS:\n");
        sb.append(est.mayorPS()).append("\n\n");
        sb.append(informePorTipo());

        return sb.toString();
    }

    public String informePorTipo() {
        StringBuilder sb = new StringBuilder();

        sb.append("-------------------------\n");
        sb.append("POKÉMON POR TIPO\n");
        sb.append("-------------------------\n\n");

        HashMap<String, Integer> cuentas = est.totalTipo();
        HashMap<String, List<String>> nombres = est.pokemonPorTipo();

        for (String tipo : cuentas.keySet()) {
            sb.append(tipo).append(": ").append(cuentas.get(tipo)).append("\n");
            for (String nombre : nombres.get(tipo)) {
                sb.append(nombre).append("\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}