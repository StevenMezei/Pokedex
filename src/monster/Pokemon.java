package monster;

import type.Type;

import java.util.List;


public class Pokemon {
    public String name;
    public Type type;
    public List<Pokemon> forms;


    public Pokemon(String name)
    {
        this.name = name;
        type = new Type();
    }

    public void addForm(String name, Type type){
        Pokemon DifferentForm = new Pokemon(name);
        DifferentForm.setType(type);
        forms.add(DifferentForm);
    }


    public Type getType() {
        return type;
    }
    public String getName(){return name;}


    public void setType(Type type){
        this.type = type;
    }
    public void addtype(String type) {
        this.type.addType(type);
    }


    public void showPokemonEffectiveness(Type usedType){
        usedType.combinedSetEffectiveness();
    }
    //EFFECTS: prints information of pokemon
    public String printAllStatements() {
        String x = print() + "\n" + printWeakness() + "\n" + printResistance() + "\n" + printImmunity() + "\n" + printNeutral();
        return x;}


    private String print () {
        return name +" is a " + type.types + " type.";
    }
    private String printWeakness () {
        return name +" has " + type.weakness.getWeaknesses().size() +" weaknesses to " + type.weakness.getWeaknesses();
    }
    private String printResistance(){
        return name +" has "+ type.weakness.getResistances().size() +" resistances to " + type.weakness.getResistances();
    }
    private String printImmunity(){
        String x = "";
        if(type.weakness.getImmunity().size()== 0){
            x = name +" has no immunities";
        }
        else
            x = name +" has " + type.weakness.getImmunity().size() +" immunities to " + type.weakness.getImmunity();
        return x;}
    private String printNeutral(){
        return name +" takes normal damage from " + type.weakness.getNeutral().size() + " types " + type.weakness.getNeutral();
    }

}
