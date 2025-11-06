package edu.trincoll.game.template;

import edu.trincoll.game.model.Character;

/**
 * Power attack sequence - charges up before attack, deals bonus damage, and suffers recoil.
 *
 * This demonstrates how the Template Method pattern allows customization
 * through hook methods. The overall turn structure is inherited from
 * BattleSequence, but we customize three steps:
 * - preAttackAction: Calculate damage bonus
 * - performAttack: Apply enhanced attack
 * - postAttackAction: Apply recoil damage
 */
public class PowerAttackSequence extends BattleSequence {
    private int damageBonus = 0;

    public PowerAttackSequence(Character attacker, Character defender) {
        super(attacker, defender);
    }

    /**
     * Charges up power before the attack.
     * 
     * Calculates a damage bonus equal to 25% of the attacker's attack power.
     * This bonus will be added to the base damage during performAttack().
     */
    @Override
    protected void preAttackAction() {
        // Calculate bonus: 25% of attack power (attack power / 4)
        damageBonus = attacker.getStats().attackPower() / 4;
    }

    /**
     * Executes the powered-up attack.
     * 
     * Combines the base attack damage with the bonus calculated in
     * preAttackAction() to deal enhanced damage to the defender.
     */
    @Override
    protected void performAttack() {
        // Calculate base damage using attacker's strategy
        int baseDamage = attacker.attack(defender);
        
        // Apply total damage (base + bonus)
        defender.takeDamage(baseDamage + damageBonus);
    }

    /**
     * Applies recoil damage to the attacker after the power attack.
     * 
     * The attacker takes 10% of their max health as recoil damage.
     * Uses takeDamage() so defense is still applied.
     */
    @Override
    protected void postAttackAction() {
        // Calculate recoil: 10% of attacker's max health
        int recoil = (int) (attacker.getStats().maxHealth() * 0.1);
        
        // Apply recoil damage to attacker
        attacker.takeDamage(recoil);
    }
}