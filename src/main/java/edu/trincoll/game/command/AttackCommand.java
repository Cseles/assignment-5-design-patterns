package edu.trincoll.game.command;

import edu.trincoll.game.model.Character;

/**
 * Command to execute an attack from one character to another.
 *
 * This class demonstrates the Command pattern by encapsulating
 * an attack action and supporting undo functionality.
 */
public class AttackCommand implements GameCommand {
    private final Character attacker;
    private final Character target;
    private int damageDealt;

    public AttackCommand(Character attacker, Character target) {
        this.attacker = attacker;
        this.target = target;
    }

    /**
     * Executes the attack command.
     * 
     * 1. Calculates damage using the attacker's attack strategy
     * 2. Applies damage to the target
     * 3. Stores the actual damage dealt for potential undo
     */
    @Override
    public void execute() {
        // Calculate damage using attacker's strategy against target
        damageDealt = attacker.attack(target);
        
        // Apply the damage to the target
        target.takeDamage(damageDealt);
    }

    /**
     * Undoes the attack command by restoring the target's health.
     * 
     * Note: This is a simplified undo. In a real game, you would
     * also need to restore mana usage, status effects, etc.
     */
    @Override
    public void undo() {
        // Restore the target's health by healing the damage dealt
        target.heal(damageDealt);
    }

    @Override
    public String getDescription() {
        return String.format("%s attacks %s", attacker.getName(), target.getName());
    }
}