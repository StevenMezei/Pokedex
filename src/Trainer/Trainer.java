
package Trainer;

import monster.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    public PokemonTeam pokemonTeam;

    public Trainer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonTeam getPokemon(){
        return pokemonTeam;
    }
}

