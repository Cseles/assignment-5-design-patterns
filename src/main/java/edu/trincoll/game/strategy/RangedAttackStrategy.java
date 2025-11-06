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
 * Ranged attack - physical damage with accuracy modifier.
 * Used by Archers.
 *
 * TODO 1c: Implement calculateDamage()
 *
 * Requirements:
 * - Base damage = attacker's attack power
 * - Apply 80% accuracy (multiply by 0.8)
 * - Add critical hit bonus: if target's health < 30% of max, add 50% bonus
 * - Return total as integer
 *
 * Example 1 (no critical): Attacker has 50 attack, target has 80/100 HP
 *   Base: 50
 *   With accuracy: 50 * 0.8 = 40
 *   Target health % = 80/100 = 80% (no critical)
 *   Return: 40
 *
 * Example 2 (critical): Attacker has 50 attack, target has 20/100 HP
 *   Base: 50
 *   With accuracy: 50 * 0.8 = 40
 *   Target health % = 20/100 = 20% (< 30%, critical!)
 *   Critical bonus: 40 * 1.5 = 60
 *   Return: 60
 */
public class RangedAttackStrategy implements AttackStrategy {
    @Override
    public int calculateDamage(Character attacker, Character target) {
        // Base damage with 80% accuracy
        int baseDamage = attacker.getStats().attackPower();
        int damageWithAccuracy = (int) (baseDamage * 0.8);
        
        // Check for critical hit: target health < 30% of max health
        int targetHealth = target.getStats().health();
        int targetMaxHealth = target.getStats().maxHealth();
        
        // Calculate if health percentage is below 30%
        if (targetHealth < targetMaxHealth * 0.3) {
            // Critical hit! Apply 1.5x damage
            damageWithAccuracy = (int) (damageWithAccuracy * 1.5);
        }
        
        return damageWithAccuracy;
    }
}
