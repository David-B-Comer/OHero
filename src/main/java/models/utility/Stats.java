package models.utility;

import models.characters.Hero;

public class Stats {
    private Integer dexterity;
    private Integer energy;
    private Integer strength;
    private Integer intellect;
    private Integer health;

    public Stats(Integer dexterity, Integer energy, Integer strength, Integer intellect, Integer health) {
        this.dexterity = dexterity;
        this.energy = energy;
        this.strength = strength;
        this.intellect = intellect;
        this.health = health;
    }

    public Stats() {

    }


    // Dexterity
    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer increaseDexterity(Integer modifier){
        return this.dexterity = this.dexterity + modifier;
    }

    public Integer decreaseDexterity(Integer modifier){
        return this.dexterity = this.dexterity - modifier;
    }


// Energy
    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer increaseEnergy(Integer modifier){
        return this.energy = this.energy + modifier;
    }

    public Integer decreaseEnergy(Integer modifier){
        return this.energy = this.energy - modifier;
    }


// Strength
    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer increaseStrength(Integer modifier){
        return this.strength = this.strength + modifier;
    }

    public Integer decreaseStrength(Integer modifier){
        return this.strength = this.strength - modifier;
    }


// Intellect
    public Integer getIntellect() {
        return intellect;
    }

    public void setIntellect(Integer intellect) {
        this.intellect = intellect;
    }

    public Integer increaseIntellect(Integer modifier){
        return this.intellect = this.intellect + modifier;
    }

    public Integer decreaseIntellect(Integer modifier){
        return this.intellect = this.intellect - modifier;
    }


// Health
    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer increaseHealth(Integer modifier){
        return this.health = this.health + modifier;
    }

    public Integer decreaseHealth(Integer modifier){
        return this.health = this.health - modifier;
    }

}
