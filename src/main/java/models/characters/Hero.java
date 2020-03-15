package models.characters;

import models.utility.HeroWarehouse;
import models.utility.Inventory;

public class Hero extends CharacterModel {

    private Inventory heroInventory;


    public Hero(String characterName, HeroWarehouse characterModelStorage) {
        super(characterName);
        this.heroInventory = new Inventory();
    }

    public Inventory getHeroInventory() {
        return heroInventory;
    }

    public void setHeroInventory(Inventory heroInventory) {
        this.heroInventory = heroInventory;
    }





}
