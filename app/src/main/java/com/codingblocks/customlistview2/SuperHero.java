package com.codingblocks.customlistview2;

import java.util.ArrayList;

public class SuperHero {

    private String name,universe,superPower;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public SuperHero(String name, String universe, String superPower) {
        this.name = name;
        this.universe = universe;
        this.superPower = superPower;
    }
    public static ArrayList<SuperHero> getrand(){
        ArrayList<SuperHero> superHeroes = new ArrayList<>();

        superHeroes.add(new SuperHero("Batman", "DC", "Rich"));
        superHeroes.add(new SuperHero("Superman", "DC", "Superhuman abilities"));
        superHeroes.add(new SuperHero("Captain America", "Marvel", "American"));
        superHeroes.add(new SuperHero("Ironman", "Marvel", "Rich"));
        superHeroes.add(new SuperHero("Green Lantern", "DC", "Magic Ring"));
        superHeroes.add(new SuperHero("Black Widow", "Marvel", "Agent"));
        superHeroes.add(new SuperHero("Shazam", "DC", "God's man"));
        superHeroes.add(new SuperHero("Hulk", "Marvel", "Smash"));
        superHeroes.add(new SuperHero("Batman", "DC", "Rich"));
        superHeroes.add(new SuperHero("Superman", "DC", "Superhuman abilities"));
        superHeroes.add(new SuperHero("Captain America", "Marvel", "American"));
        superHeroes.add(new SuperHero("Ironman", "Marvel", "Rich"));
        superHeroes.add(new SuperHero("Green Lantern", "DC", "Magic Ring"));
        superHeroes.add(new SuperHero("Black Widow", "Marvel", "Agent"));
        superHeroes.add(new SuperHero("Shazam", "DC", "God's man"));
        superHeroes.add(new SuperHero("Hulk", "Marvel", "Smash"));
return superHeroes;

    }
}