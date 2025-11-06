package edu.trincoll.game.command;

import edu.trincoll.game.model.Character;

/**
 * Command to heal a character.
 *
 * This class demonstrates the Command pattern by encapsulating
 * a healing action and supporting undo functionality.
 * 
 * Note: This command tracks the actual healing done since characters
 * cannot be healed above their maximum health.
 */
public class HealCommand implements GameCommand {
    private final Character target;
    private final int amount;
    private int actualHealingDone;

    public HealCommand(Character target, int amount) {
        this.target = target;
        this.amount = amount;
    }

    /**
     * Executes the heal command.
     * 
     * 1. Records the target's health before healing
     * 2. Applies the healing to the target
     * 3. Calculates actual healing done (respects max health cap)
     */
    @Override
    public void execute() {
        // Store health before healing
        int healthBefore = target.getStats().health();
        
        // Apply healing to the target
        target.heal(amount);
        
        // Calculate actual healing done (may be less than amount if at max health)
        int healthAfter = target.getStats().health();
        actualHealingDone = healthAfter - healthBefore;
    }

    /**
     * Undoes the heal command by removing the healing that was applied.
     * 
     * Uses takeDamage() to reverse the healing effect, which will
     * still respect defense calculations.
     */
    @Override
    public void undo() {
        // Remove the healing by dealing damage equal to actual healing done
        target.takeDamage(actualHealingDone);
    }

    @Override
    public String getDescription() {
        return String.format("Heal %s for %d HP", target.getName(), amount);
    }
}