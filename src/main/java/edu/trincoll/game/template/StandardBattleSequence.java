package edu.trincoll.game.template;

import edu.trincoll.game.model.Character;

/**
 * Standard battle sequence - simple attack with no special actions.
 *
 * This concrete implementation demonstrates the Template Method pattern
 * by providing a specific implementation of the performAttack() step
 * while inheriting the overall battle turn structure from BattleSequence.
 */
public class StandardBattleSequence extends BattleSequence {

    public StandardBattleSequence(Character attacker, Character defender) {
        super(attacker, defender);
    }

    /**
     * Implements the standard attack behavior.
     * 
     * This is a straightforward attack with no modifiers or special effects.
     * The damage calculation uses the attacker's strategy and the defender's
     * defense is applied automatically through takeDamage().
     */
    @Override
    protected void performAttack() {
        // Calculate damage using attacker's attack strategy
        int damage = attacker.attack(defender);
        
        // Apply damage to defender (defense is applied automatically)
        defender.takeDamage(damage);
    }
}