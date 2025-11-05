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
 * Heavy armor defense - better damage reduction than standard.
 * Used by Warriors.
 *
 * TODO 1e: Implement calculateDamageReduction()
 *
 * Requirements:
 * - Calculate damage reduction: defense (full defense value)
 * - Actual damage = incoming damage - damage reduction
 * - Ensure actual damage is never negative (minimum 0)
 * - Maximum 75% damage reduction (even if defense is very high)
 *
 * Example 1: Defender has 30 defense, incoming damage is 100
 *   Damage reduction: 30
 *   Actual damage: 100 - 30 = 70
 *   Return: 70
 *
 * Example 2: Defender has 80 defense, incoming damage is 100
 *   Theoretical reduction: 80 (would leave 20 damage)
 *   But max reduction is 75%, so: 100 * 0.25 = 25
 *   Return: 25
 */
public class HeavyArmorDefenseStrategy implements DefenseStrategy {
    @Override
    public int calculateDamageReduction(Character defender, int incomingDamage) {
        // Full defense value as reduction
        int damageReduction = defender.getStats().defense();
        
        // Calculate actual damage
        int actualDamage = incomingDamage - damageReduction;
        
        // Apply 75% reduction cap: minimum 25% of damage must get through
        int minimumDamage = (int) (incomingDamage * 0.25);
        
        // Return the larger of: actualDamage or minimumDamage
        return Math.max(minimumDamage, actualDamage);
    }
}
