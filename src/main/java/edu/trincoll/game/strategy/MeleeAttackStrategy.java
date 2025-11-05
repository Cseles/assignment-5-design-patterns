package edu.trincoll.game.strategy;

import edu.trincoll.game.model.Character;

/**
 * AI Collaboration Summary:
 * Tool: Claude
 *
 * What AI Helped With:
 * 1. Provided step-by-step implementation guide for strategy calculations
 * 2. Explained the mathematical formulas for each strategy type
 *
 * What I Had to Fix:
 * [Add anything you changed or debugged]
 *
 * What I Learned:
 * - How the Strategy pattern allows interchangeable algorithms
 * - Using integer division and casting for game damage calculations
 * - Why Math.max() is used to prevent negative damage
 *
 * Team: Daniel Simon
 */

/**
 * Melee attack - straightforward physical damage based on attack power.
 * Used by Warriors and Rogues.
 *
 * TODO 1a: Implement calculateDamage()
 *
 * Requirements:
 * - Base damage = attacker's attack power
 * - Add 20% bonus damage (multiply by 1.2)
 * - Return the total as an integer
 *
 * Example: If attacker has 50 attack power:
 *   Base: 50
 *   With bonus: 50 * 1.2 = 60
 *   Return: 60
 */
public class MeleeAttackStrategy implements AttackStrategy {
    @Override
    public int calculateDamage(Character attacker, Character target) {
        // Get base damage from attacker's attack power
        int baseDamage = attacker.getStats().attackPower();
        
        // Add 20% bonus (multiply by 1.2)
        int totalDamage = (int) (baseDamage * 1.2);
        
        return totalDamage;
    }   
}
