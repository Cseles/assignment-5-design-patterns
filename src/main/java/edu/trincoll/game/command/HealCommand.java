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
    private int originalHealth;  // store health before execute()

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
        // Health before healing
        originalHealth = target.getStats().health();

        // Apply healing
        target.heal(amount);

        // Health after healing
        int healthAfter = target.getStats().health();

        // Track actual healing done (for info/tests)
        actualHealingDone = healthAfter - originalHealth;
    }

    @Override
    public void undo() {
        // Restore *exact* original health (bypass defense)
        target.setHealth(originalHealth);
    }

    @Override
    public String getDescription() {
        return String.format("Heal %s for %d HP", target.getName(), amount);
    }
}