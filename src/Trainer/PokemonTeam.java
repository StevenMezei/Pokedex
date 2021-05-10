package Trainer;

import exceptions.NoPokemonException;
import monster.Pokemon;
import type.AvailableTypes;
import type.Type;
import type.Weakness;

import java.util.*;

public class PokemonTeam {
    public List<Pokemon> pokemonList;
    public TeamAnalysis analysis;
    private AvailableTypes availableTypes = new AvailableTypes();
    public TypeScoreList typeScoreList;

    public PokemonTeam () {
        pokemonList = new ArrayList<>();
    }

    public String showTypeEffectiveness(String type){
        analysis = new TeamAnalysis();
        analyzeTeam(type);
        String x = printHowGoodTypeIs(type);
        return x;}

    public String showBestTypes(){
        analysis = new TeamAnalysis();
        typeScoreList = new TypeScoreList();
        bestTypes();
        String x = "Calculations: 4x = 9 points, 2x = 7 points, 1x = 5 points, 0.5x = 2 points, 0.25x = 1 point, 0x = 0 points";
        for(String s: typeScoreList.getSortedList()){
            x = x + "\n" + s;

        }
        return x;}

    public void addPokemon(Pokemon pokemon){
        pokemonList.add(pokemon);
    }

    private void analyzeTeam(String type){
        for(Pokemon p: pokemonList){
            analysis.analyzeType(p.getType(),type);
        }
    }

    public void removeAllPokemon(){
        pokemonList = new ArrayList<>();
    }


    private void bestTypes(){
        for(String s: availableTypes.getAvailableTypes()){
            analyzeTeam(s);
            Integer score = analysis.teamAnalysisScore();
            TypeScore ts = new TypeScore(s,score);
            typeScoreList.add(ts);
            typeScoreList.sortTypeScores();
            analysis.resetEffectiveness();
        }
    }
    /*private void bestTypes(){
        for(String s: availableTypes.getAvailableTypes()){
            analyzeTeam(s);
            Integer score = analysis.teamAnalysisScore();
            typeScores.put(s,score);
            analysis.resetEffectiveness();
        }
    }*/


   /* private List<String> rankTypes() {
        List<String> rankedTypes = new ArrayList<>();
        for (String s : availableTypes.getAvailableTypes()) {
            Integer score = typeScores.get(s);
            rankedTypes.add(s + " " + Integer.toString(score));
        }
        return rankedTypes;
    }*/







    private String printHowGoodTypeIs(String type){
        return type + " is super duper (4x) effective against " + analysis.getSuperDuperEffective() + " pokemon." + "\n" +
                type + " is super effective (2x) against " + analysis.getSuperEffective() + " pokemon."+ "\n" +
                type + " is neutral (1x) against " + analysis.getNeutralEffect() + " pokemon." + "\n" +
                type + " is not very effective (0.5x) against " + analysis.getNotVeryEffective() + " pokemon." + "\n" +
                type + " is barely (0.25x) effective against " + analysis.getBarelyEffective() + " pokemon." + "\n" +
                type + " has no effect (0x) against " + analysis.getNoEffect() + " pokemon.";

    }

    public List<String> getNames() throws NoPokemonException {
        List<String> pokeNames = new ArrayList<>();
        if(pokemonList.isEmpty()){
            throw new NoPokemonException();
        }
        for(Pokemon p: pokemonList){
            pokeNames.add(p.getName());
        }
        return pokeNames;}

    public List<String> attemptGetNames(){
        List<String> pokeNames = new ArrayList<>();
        try{
            pokeNames = getNames();
        }
        catch (NoPokemonException e){
            System.out.println("You don't have any Pokemon!");
        }
        return pokeNames;
    }

    public Boolean containsPokemon(String name){
        for(Pokemon p: pokemonList){
            if(p.getName().equals(name)){
                return true;
            }
        }
        return false;
    }



    public String getStringListPokemon(){
        List<String> pokeNames = attemptGetNames();
        String name = String.join(", ",pokeNames);
        return name;}

    public void removePokemon(Pokemon pokemon){
        pokemonList.remove(pokemon);
    }

}
