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
 * Standard defense - reduces damage by a percentage of defense stat.
 * Used by most character types.
 *
 * TODO 1d: Implement calculateDamageReduction()
 *
 * Requirements:
 * - Calculate damage reduction: defense / 2
 * - Actual damage = incoming damage - damage reduction
 * - Ensure actual damage is never negative (minimum 0)
 *
 * Example: Defender has 20 defense, incoming damage is 50
 *   Damage reduction: 20 / 2 = 10
 *   Actual damage: 50 - 10 = 40
 *   Return: 40
 */
public class StandardDefenseStrategy implements DefenseStrategy {
    @Override
    public int calculateDamageReduction(Character defender, int incomingDamage) {
        // Calculate damage reduction (defense divided by 2)
        int damageReduction = defender.getStats().defense() / 2;
        
        // Calculate actual damage after reduction
        int actualDamage = incomingDamage - damageReduction;
        
        // Make sure damage is never negative
        return Math.max(0, actualDamage);
    }  
}
