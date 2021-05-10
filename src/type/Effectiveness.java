package type;

import java.util.*;


public class Effectiveness {

    public List<Integer> defEff;



    public List<Integer> getDefEff() {
        return defEff;
    }

    public void setDefEff(List<Integer> defEff) {
        this.defEff = defEff;
    }

    public Effectiveness(){
        this.defEff = new ArrayList<>();
        for (int x=0; (x<18); x++){
            defEff.add(4);
        }
    }

    // REQUIRES: a list of types that are capitalized
    // MODIFIES: this
    // EFFECT: Based on the type/type combo, change the effectiveness

    public void setResistances(List<String> types){
        if(types.contains("Normal")){
            setNormal();
        }

        if (types.contains("Fire")){
            setFire();
        }
        if (types.contains("Water")){
            setWater();
        }
        if (types.contains("Grass")) {
            setGrass();
        }
        if (types.contains("Electric")){
            setElectric();
        }
        if (types.contains("Ice")){
            setIce();
        }
        if (types.contains("Fighting")){
            setFighting();
        }
        if (types.contains("Poison")){
            setPoison();
        }
        if (types.contains("Ground")){
            setGround();
        }
        if (types.contains("Flying")){
            setFlying();
        }
        if (types.contains("Psychic")){
            setPsychic();
        }
        if (types.contains("Bug")){
            setBug();
        }
        if (types.contains("Rock")){
            setRock();
        }
        if (types.contains("Ghost")){
            setGhost();
        }
        if (types.contains("Dragon")){
            setDragon();
        }
        if (types.contains("Dark")){
            setDark();
        }
        if (types.contains("Steel")){
            setSteel();
        }
        if (types.contains("Fairy")){
            setFairy();
        }

    }

    //MODIFIES: this
    //EFFECTS: Changes the type effectiveness based on the type inputted
    private void setNormal(){
        List <Integer> weakness = Arrays.asList(6);
        List<Integer> immunity = Arrays.asList(13);
        List <Integer> resistance = Arrays.asList();
        setAll(weakness,resistance,immunity);
    }


    private void setWater(){
        List <Integer> resistance = Arrays.asList(1,2,5,16);
        List <Integer> weakness = Arrays.asList(3,4);
        List <Integer> immunity = Arrays.asList();
        setAll(weakness,resistance,immunity);

    }

    private void setFire(){
        List <Integer> resistance = Arrays.asList(1,3,5,11,16,17);
        List <Integer> weakness = Arrays.asList(2,8,12);
        List <Integer> immunity = Arrays.asList();
        setAll(weakness,resistance,immunity);

    }
    private void setGrass(){
        List <Integer> resistance = Arrays.asList(2,3,4,8);
        List <Integer> weakness = Arrays.asList(1,5,7,9,11);
        List <Integer> immunity = Arrays.asList();
        setAll(weakness,resistance,immunity);
    }

    private void setElectric(){
        List <Integer> resistance = Arrays.asList(4,9);
        List <Integer> weakness = Arrays.asList(8);
        List <Integer> immunity = Arrays.asList();
        setAll(weakness,resistance,immunity);

    }
    private void setIce(){
        List <Integer> resistance = Arrays.asList(5);
        List <Integer> weakness = Arrays.asList(1,6,12,16);
        List <Integer> immunity = Arrays.asList();
        setAll(weakness,resistance,immunity);
    }
    private void setFighting(){
        List <Integer> resistance = Arrays.asList(11,12,15);
        List <Integer> weakness = Arrays.asList(9,10,17);
        List <Integer> immunity = Arrays.asList();
        setAll(weakness,resistance,immunity);
    }

    private void setPoison(){
        List <Integer> resistance = Arrays.asList(3,6,7,11,17);
        List <Integer> weakness = Arrays.asList(8,10);
        List <Integer> immunity = Arrays.asList();
        setAll(weakness,resistance,immunity);
    }

    private void setGround(){
        List <Integer> resistance = Arrays.asList(7,12);
        List <Integer> weakness = Arrays.asList(2,3,5);
        List<Integer> immunity = Arrays.asList(4);
        setAll(weakness,resistance,immunity);
    }

    private void setFlying(){
        List <Integer> resistance = Arrays.asList(3,6,11);
        List <Integer> weakness = Arrays.asList(4,5,12);
        List<Integer> immunity = Arrays.asList(8);
        setAll(weakness,resistance,immunity);
    }

    private void setPsychic(){
        List <Integer> resistance = Arrays.asList(6,10);
        List <Integer> weakness = Arrays.asList(11,13,15);
        List <Integer> immunity = Arrays.asList();
        setAll(weakness,resistance,immunity);
    }

    private void setBug(){
        List <Integer> resistance = Arrays.asList(3,6,8);
        List <Integer> weakness = Arrays.asList(1,9,12);
        List <Integer> immunity = Arrays.asList();
        setAll(weakness,resistance,immunity);
    }
    private void setRock(){
        List <Integer> resistance = Arrays.asList(0,1,7,9);
        List <Integer> weakness = Arrays.asList(2,3,6,8,16);
        List <Integer> immunity = Arrays.asList();
        setAll(weakness,resistance,immunity);
    }
    private void setGhost(){
        List <Integer> resistance = Arrays.asList(7,11);
        List <Integer> weakness = Arrays.asList(13,15);
        List<Integer> immunity = Arrays.asList(0,6);
        setAll(weakness,resistance,immunity);
    }
    private void setDragon(){
        List <Integer> resistance = Arrays.asList(1,2,3,4);
        List <Integer> weakness = Arrays.asList(5,14,17);
        List <Integer> immunity = Arrays.asList();
        setAll(weakness,resistance,immunity);

    }
    private void setDark (){
        List <Integer> resistance = Arrays.asList(13,15);
        List <Integer> weakness = Arrays.asList(6,11,17);
        List <Integer> immunity = Arrays.asList(10);
        setAll(weakness,resistance,immunity);
    }
    private void setSteel(){
        List <Integer> resistance = Arrays.asList(0,3,5,9,10,11,12,14,16,17);
        List <Integer> weakness = Arrays.asList(1,6,8);
        List <Integer> immunity = Arrays.asList(7);
        setAll(weakness,resistance,immunity);

    }
    private void setFairy(){
        List <Integer> resistance = Arrays.asList(6,11,15);
        List <Integer> weakness = Arrays.asList(7,16);
        List <Integer> immunity = Arrays.asList(14);
        setAll(weakness,resistance,immunity);
    }



    private void setAll(List<Integer> w, List<Integer> r, List<Integer> i){
        for (int x=0; x<w.size(); x++){
            int value = w.get(x);
            defEff.set(value,defEff.get(value)*2);}
        for (int x=0; x<r.size(); x++) {
            int value = r.get(x);
            defEff.set(value,defEff.get(value)/2);
        }
        for (int x=0; x<i.size(); x++) {
            defEff.set(i.get(x),0);
        }
    }
}
