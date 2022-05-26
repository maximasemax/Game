package model.impl;

public class Person {
    public String name;
    public float hp;
    public float attackSkill;
    public float defenceSkill;


    public Person(String name, float hp, float attackSkill, float defenceSkill) {
        this.name = name;
        this.attackSkill = attackSkill;
        this.defenceSkill = defenceSkill;
        this.hp = hp;
    }

    public Person() {
    }

    public float getAttackSkill() {
        return attackSkill;
    }

    public float getDefenceSkill() {
        return defenceSkill;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDefenceSkill(float defenceSkill) {
        this.defenceSkill = defenceSkill;
    }

    public void setAttackSkill(float attackSkill) {
        this.attackSkill = attackSkill;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append("\n");
        stringBuilder.append(attackSkill);
        stringBuilder.append("\n");
        stringBuilder.append(defenceSkill);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
