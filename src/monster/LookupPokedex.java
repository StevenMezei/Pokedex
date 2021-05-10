package monster;

import exceptions.NoPokemonException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LookupPokedex {
    public HashMap<String, Pokemon> pokeDatabase;


    public LookupPokedex() throws IOException {
        pokeDatabase = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get("Gen3 Pokedatabase.csv"));
        for (String line : lines){
            ArrayList<String> partsOfLine = splitOnComma(line);
            if(partsOfLine.size()<4){
                addMonoPokemon(partsOfLine.get(1),partsOfLine.get(2));
            }
            else {
                addDuoPokemon(partsOfLine.get(1), partsOfLine.get(2), partsOfLine.get(3));
            }
        }
    }

    public void addMonoPokemon(String name, String type1){
        Pokemon nameless = new Pokemon(name);
        nameless.type.addType(type1);
        nameless.showPokemonEffectiveness(nameless.getType());
        pokeDatabase.put(removeNonAlphaNumerals(name),nameless);
    }

    public void addDuoPokemon(String name, String type1, String type2){
        Pokemon nameless = new Pokemon(name);
        nameless.type.addType(type1);
        nameless.addtype(type2);
        nameless.showPokemonEffectiveness(nameless.getType());
        pokeDatabase.put(removeNonAlphaNumerals(name),nameless);
    }

    public String removeNonAlphaNumerals(String s){
        String x = s.replaceAll("-","");
        String z = x.replaceAll("\\s", "");
        String y = setText(z);
        return y;}




    public Pokemon attemptSearchPokemon(String s) {
        Pokemon searchedfor = null;
        try {
            searchedfor = searchPokemon(s);

        } catch (NoPokemonException e) {
            System.out.println("Pokemon could not be found.");
        }
        return searchedfor;
    }

    public Pokemon searchPokemon(String s)throws NoPokemonException{
        if(!pokeDatabase.containsKey(s)){
            throw new NoPokemonException();
        }
        return pokeDatabase.get(s);
    }

    public Boolean containsPokemon(String s){
        Boolean x = pokeDatabase.containsKey(s);
        return x;}

    public void searchPokemonStats(String s) throws MalformedURLException {
        String pokemonURL = "https:/api/v2/pokemon/" + s + "/stats/";
        URL url = new URL(pokemonURL);
        System.out.println(url);
    }



    public static ArrayList<String> splitOnComma(String line){
        String[] splits = line.split(",");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public String setText(String s){
        String x = "";
        if(s.isEmpty()){
            x = s;
        }
        else{
            x = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
        }
        return x;}

}


//FileInputStream file = new FileInputStream(new File("C:\\Users\\steve\\Documents\\Documents\\UBC\\Year 2 Term 1\\CPSC 210"));
// XSSFWorkbook workbook = new XSSFWorkbook(file);