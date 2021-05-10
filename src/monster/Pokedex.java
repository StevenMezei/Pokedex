package monster;

import Observer.SubjectPokedex;
import exceptions.NoPokemonException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pokedex extends SubjectPokedex {
    public List<Pokemon> pokemonSeen;
    public List<OwnedPokemon> pokemonCaught;

    public Pokedex(){
        pokemonSeen = new ArrayList<>();
        pokemonCaught = new ArrayList<>();
    }

    public void addSeenPokemon(Pokemon pokemon){
        pokemonSeen.add(pokemon);
    }

    public List<Pokemon> getPokemonSeen() {
        return pokemonSeen;
    }

    public List<OwnedPokemon> getPokemonCaught() {
        return pokemonCaught;
    }

    public void addCaughtPokemon(OwnedPokemon pokemon){
        addSeenPokemon(pokemon);
        pokemonCaught.add(pokemon);
    }

    public void feedPokemon(String pokemonToLookFor) throws NoPokemonException {
        for (int x = 0; x < pokemonCaught.size(); x++) {
            if (pokemonCaught.get(x).getNickname().equals(pokemonToLookFor)) {
                pokemonCaught.get(x).feedPokesnax();
            } else {
                System.out.println("You do not own that pokemon");
            }
        }
        if(pokemonCaught.isEmpty()){
            throw new NoPokemonException();
        }
    }


}
