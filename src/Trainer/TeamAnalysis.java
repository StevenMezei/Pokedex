package Trainer;

import type.Effectiveness;
import type.Type;

import java.util.HashMap;

public class TeamAnalysis {

    private Integer superDuperEffective;
    private Integer superEffective;
    private Integer neutralEffect;
    private Integer notVeryEffective;
    private Integer barelyEffective;
    private Integer noEffect;

    public TeamAnalysis(){
        this.barelyEffective = 0;
        this.noEffect = 0;
        this.neutralEffect = 0;
        this.notVeryEffective = 0;
        this.superDuperEffective = 0;
        this.superEffective = 0;
    }

    public void analyzeType(Type type,String attack){
        if(type.weakness.resistances.contains(attack)){
            notVeryEffective++;
        }
        if(type.weakness.resistances.contains(attack+"(0.25x)")){
            barelyEffective++;}


        if(type.weakness.weaknesses.contains(attack)){
            superEffective++;
        }
        if(type.weakness.weaknesses.contains(attack+"(4x)")) {
            superDuperEffective++;
        }

        if(type.weakness.neutral.contains(attack)){
            neutralEffect++;
        }
        if(type.weakness.immunity.contains(attack)){
            noEffect++;
        }
    }

    public Integer getSuperDuperEffective() {
        return superDuperEffective;
    }

    public void setSuperDuperEffective(Integer superDuperEffective) {
        this.superDuperEffective = superDuperEffective;
    }

    public Integer getSuperEffective() {
        return superEffective;
    }

    public void setSuperEffective(Integer superEffective) {
        this.superEffective = superEffective;
    }

    public Integer getNeutralEffect() {
        return neutralEffect;
    }

    public void setNeutralEffect(Integer neutralEffect) {
        this.neutralEffect = neutralEffect;
    }

    public Integer getNotVeryEffective() {
        return notVeryEffective;
    }

    public void setNotVeryEffective(Integer notVeryEffective) {
        this.notVeryEffective = notVeryEffective;
    }

    public Integer getBarelyEffective() {
        return barelyEffective;
    }

    public void setBarelyEffective(Integer barelyEffective) {
        this.barelyEffective = barelyEffective;
    }

    public Integer getNoEffect() {
        return noEffect;
    }

    public void setNoEffect(Integer noEffect) {
        this.noEffect = noEffect;
    }

    public void resetEffectiveness(){
        this.barelyEffective = 0;
        this.noEffect = 0;
        this.neutralEffect = 0;
        this.notVeryEffective = 0;
        this.superDuperEffective = 0;
        this.superEffective = 0;
    }

    public Integer teamAnalysisScore(){
        Integer score = this.barelyEffective*1 + this.notVeryEffective*2 + this.neutralEffect*5 + this.superEffective*7 + this.superDuperEffective*9;
        return score;}

}
