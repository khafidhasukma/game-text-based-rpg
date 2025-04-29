package enemy;

import character.Character;

public class Enemy extends Character {

    // Constructor to initialize enemy attributes
    public Enemy(String name, int hp, int attackPower, int defense) {
        super(name, hp, attackPower, defense);
    }

    @Override
    // Method to handle enemy attack
    public void attack(Character character) {
        int damage = this.attackPower;
        System.out.println(name + " menyerang balik! Damage: " + damage);
        character.receiveDamage(damage);
    }
}
