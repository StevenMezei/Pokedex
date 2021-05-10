package Test;

import exceptions.NoPokemonException;
import monster.Pokemon;
import monster.OwnedPokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import static org.junit.jupiter.api.Assertions.*;

public class NoPokemonExceptionTest {
    Scanner scanner = new Scanner(System.in);
    List<Pokemon> pokedexSoFar;
    List<OwnedPokemon> caughtPokemon;
    List<String> availableTypes;

    @BeforeEach
    public void beforeTest(){
        caughtPokemon = new ArrayList<>();
    }


    @Test
    public void testEmptyList() throws NoPokemonException, IOException{
        try{
            feedPokemon("Mudkip");
            fail("You shouldn't be here");
        }catch (NoPokemonException e){}

    }

    @Test
    public void testNonEmptyList(){
        OwnedPokemon mudkip = new OwnedPokemon("Mudkip");
        caughtPokemon.add(mudkip);
        try{
            feedPokemon("Mudkip");
        }catch(NoPokemonException e){
            fail("Why didn't you feed your pokemon? :(");
        }
    }

    public void feedPokemon(String pokemonToLookFor) throws NoPokemonException {
        for (int x = 0; x < caughtPokemon.size(); x++) {
            if (caughtPokemon.get(x).getNickname().equals(pokemonToLookFor)) {
                caughtPokemon.get(x).feedPokesnax();
            } else {
                System.out.println("You do not own that pokemon");
            }
        }
        if(caughtPokemon.isEmpty()){
            throw new NoPokemonException();
        }
    }
}
