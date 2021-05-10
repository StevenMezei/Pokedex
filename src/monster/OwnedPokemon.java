package monster;

public class OwnedPokemon extends Pokemon {

    public int level;
    public int affection;
    public String nickname;

    public OwnedPokemon(String name){
        super(name);
        this.level = 1;
        this.nickname = name;
    }

    public void setLevel(int i){
        this.level = i;
    }

    public void feedPokesnax(){
        System.out.println(getNickname() + " appreciates the snack, affection has gone up by 5");
        this.affection = affection + 5;
    }

    public String getNickname() { return nickname; }



    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
