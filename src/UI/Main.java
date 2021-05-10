package ui;

import Trainer.PokemonTeam;
import monster.LookupPokedex;
import monster.Pokemon;
import type.AvailableTypes;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Main extends JFrame implements ActionListener {

    private JLabel label;
    private JTextField field;
    private JPanel announcementPanel;
    private Clip clip;
    private JTextArea display;
    private PokemonTeam pokemonTeam = new PokemonTeam();
    private LookupPokedex lookupPokedex = new LookupPokedex();
    AvailableTypes availableTypes1 = new AvailableTypes();




    public Main() throws IOException {
        super("Pokedex");
        this.setContentPane(new JLabel(new ImageIcon((ImageIO.read(new File("Pokedex.png"))))));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(775, 500));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        addComponents();
        label.setText("Roster: ");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        playMusic("BlackAndWhiteMusic.wav");
    }

    public void addComponents() {
        JButton btn = new JButton("Add");
        JButton remove = new JButton("Remove");
        JButton btn2 = new JButton("Lookup");
        JButton bt3 = new JButton("Analyze Type");
        JButton btn4 = new JButton("Remove All");
        JButton btn5 = new JButton("Best Types");
        JButton btn6 = new JButton("Help");
        JButton btn7 = new JButton("Music");
        btn.setActionCommand("Add");
        remove.setActionCommand("Remove");
        remove.addActionListener(this);
        btn.addActionListener(this);
        btn2.addActionListener(this);
        bt3.addActionListener(this);
        bt3.setActionCommand("Analyze Type");
        btn4.addActionListener(this);
        btn4.setActionCommand("Remove All");
        btn5.addActionListener(this);
        btn5.setActionCommand("Best Types");
        btn6.setActionCommand("Help");
        btn6.addActionListener(this);
        btn7.setActionCommand("Music");
        btn7.addActionListener(this);
        label = new JLabel("");
        label.setForeground(Color.green);
        field = new JTextField(10);
        add(field);
        add(btn);
        add(remove);
        add(btn2);
        add(bt3);
        add(btn5);
        add(btn4);
        add(btn7);
        add(btn6);
        addTextDisplay();
        add(label);
    }

    void addTextDisplay() {
        announcementPanel = new JPanel();
        announcementPanel.setBorder(new TitledBorder(new EtchedBorder(), "Announcement Area"));
        display = new JTextArea("Hello trainer, I am your Pokedex! Enter the name of a Pokemon or Pokemon type!", 16, 65);
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        announcementPanel.add(scroll);
        add(announcementPanel);


    }


    //this is the method that runs when Swing registers an action on an element
    //for which this class is an ActionListener
    public void actionPerformed(ActionEvent e) {

        String x = field.getText();
        String nameless = setText(x);
        String addNameless = lookupPokedex.removeNonAlphaNumerals(nameless);
        if (e.getActionCommand().equals("Add")) {

            if (!lookupPokedex.pokeDatabase.containsKey(addNameless)) {
                display.setText("Pokemon could not be found!");
            } else {
                Pokemon addedPokemon = lookupPokedex.attemptSearchPokemon(addNameless);
                pokemonTeam.addPokemon(addedPokemon);
                display.setText(addedPokemon.getName() + " has been added to your team!");
            }
            label.setText("Roster: " + pokemonTeam.getStringListPokemon());
        }
        if (e.getActionCommand().equals("Remove")) {
            if (!lookupPokedex.pokeDatabase.containsKey(addNameless)) {
                display.setText("Pokemon could not be found!");}

            else {
                Pokemon removedPokemon = lookupPokedex.attemptSearchPokemon(addNameless);
                String removedName = removedPokemon.getName();
                if (!pokemonTeam.containsPokemon(removedName)) {
                    display.setText("Pokemon not on your roster!");
                }   else {
                    pokemonTeam.removePokemon(removedPokemon);
                    display.setText(removedName + " has been removed from your team!");
                }
                label.setText("Roster: " + pokemonTeam.getStringListPokemon());
            }
        }
        if (e.getActionCommand().equals("Lookup")) {

            if (!lookupPokedex.containsPokemon(addNameless)) {
                display.setText("Pokemon could not be found!");
            } else {
                Pokemon pokemon = lookupPokedex.attemptSearchPokemon(addNameless);
                display.setText(pokemon.printAllStatements());
            }

        }

        if (e.getActionCommand().equals("Analyze Type")) {
            if (!availableTypes1.contains(nameless)) {
                display.setText("That's not a type!");
            } else {
                display.setText(pokemonTeam.showTypeEffectiveness(nameless));
            }
        }

        if(e.getActionCommand().equals("Best Types")){
            if(pokemonTeam.pokemonList.isEmpty()){
                display.setText("You don't have any Pokemon!");
            }
            else {
                display.setText(pokemonTeam.showBestTypes());
            }
        }

        if (e.getActionCommand().equals("Remove All")) {
            if (pokemonTeam.pokemonList.isEmpty()) {
                display.setText("You don't have any Pokemon!");
            }
            display.setText("Are you sure you want to remove all your Pokemon?" + "\n" +
                    "If yes, type in yes into the text box and hit Remove All again");
            if (nameless.equals("Yes")) {
                pokemonTeam.removeAllPokemon();
                display.setText("All Pokemon have been removed");
                label.setText("Roster: " + pokemonTeam.getStringListPokemon());
            }
        }

        if(e.getActionCommand().equals("Music")){
            if(nameless.equals("One")||x.equals("1")){
                stopMusic();
                playMusic("RedAndBlueMusic.wav");
            }
            if(nameless.equals("Two")||x.equals("2")){
                stopMusic();
                playMusic("BlackAndWhiteMusic.wav");
            }
            if(nameless.equals("Three")||x.equals("3")){
                stopMusic();
                playMusic("OrasMusic.wav");
            }
            if(nameless.equals("Stop")||x.equals("0")){
                stopMusic();
            }
            else {
                display.setText("Enter in numbers from 1-3 to get different Pokemon music and click the music button"+
                        "\nIf you want to turn of the music type in 'Stop' or '0' and click the music button.");
            }


        }

        if(e.getActionCommand().equals("Help")){
            setHelpPanel();
        }


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

    public void stopMusic(){
        if (clip.isRunning()){
            clip.stop();
        }
    }

    public void setHelpPanel(){
        display.setText("Information about this pokedex:\nAdd: Type in a pokemon's name into the text box and hit the button. Make sure not to put in non-alphanumerics into the text box" +
                "\nRemove: Type in the pokemon's name that you want to remove you from the roster (You have to type the name of the Pokemon how it shows up on your roster)."+
                "\nLookup: Type in the pokemon's name, and I will show you it's type, resistance, weaknesses and immunities."+
                "\nAnalyze Type: Type in one of the 18 types in pokemon, and I will show you how well it attacks the current Pokemon roster."+
                "\nBest Types: Sorts the best types that can attack this Pokemon roster."+
                "\nRemove All: Removes all Pokemon on your roster."+
                "\nMusic: Change or mute the music with this button."+
                "\nHelp: Brings up this panel again."+
                "\nNote: If you want to add an Alolan Pokemon, type in 'alola' after the pokemon's name in order to add it to your roster.");
    }

    public void playMusic(String st){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(st).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }






    public static void main(String[] args) throws IOException{

        {
        }
        new Main();

    }
}