package character;

public class Character {
    protected String name;
    protected int hp;
    protected int attackPower;
    protected int defense;
    protected int potions = 3;

    // Constructor to initialize character attributes
    public Character(String name, int hp, int attackPower, int defense) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    // Getter for character's name
    public String getName() {
        return name;
    }
    
    // Getter for the number of potions left
    public int getPotions() {
        return potions;
    }
    
    // Getter for attack power
    public int getAttackPower() {
        return attackPower;
    }

    // Getter for character's HP
    public int getHp() {
        return hp;
    }

    // Method attack
    public void attack(Character enemy) {
        int damage = this.attackPower;
        System.out.println(name + " menyerang " + enemy.name + "! Damage: " + damage);
        enemy.receiveDamage(damage);
    }

    // Overloaded method for attack with bonus
    public void attack(Character enemy, int bonusDamage) {
        int damage = this.attackPower + bonusDamage;
        System.out.println(name + " menyerang dengan kekuatan tambahan! Damage: " + damage);
        enemy.receiveDamage(damage);
    }

    // Method for defend against incoming damage
    public void defend(int incomingDamage, String attackerName) {
        System.out.println(attackerName + " menyerang! Damage: " + incomingDamage);
        int reducedDamage = Math.max(0, incomingDamage - this.defense);
        this.hp -= reducedDamage;
        if (this.hp < 0) this.hp = 0;
        System.out.println(name + " bertahan! Damage yang diterima dikurangi jadi " + reducedDamage);
    }

    // Method for drink a potion to restore HP
    public void drinkPotion() {
        if (potions > 0) {
            hp += 20;
            potions--;
            System.out.println(name + " meminum ramuan! HP bertambah 20. Sisa ramuan: " + potions);
        } else {
            System.out.println("Ramuan habis!");
        }
    }

    // Method for receiving damage from an attack
    public void receiveDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) this.hp = 0;
    }
}
