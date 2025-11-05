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
 * Magic attack - uses mana and attack power to calculate damage.
 * Used by Mages.
 *
 * TODO 1b: Implement calculateDamage()
 *
 * Requirements:
 * - Base damage = attacker's attack power
 * - Mana bonus = current mana / 10 (integer division)
 * - Total damage = base + mana bonus
 * - Reduce attacker's mana by 10 (use attacker.useMana(10))
 *   NOTE: If not enough mana, useMana() will throw an exception
 *
 * Example: If attacker has 60 attack power and 50 mana:
 *   Base: 60
 *   Mana bonus: 50 / 10 = 5
 *   Total: 65
 *   After attack: mana reduced by 10
 */
public class MagicAttackStrategy implements AttackStrategy {
    @Override
public int calculateDamage(Character attacker, Character target) {
    // Base damage from attack power
    int baseDamage = attacker.getStats().attackPower();
    
    // Calculate mana bonus (current mana divided by 10)
    int manaBonus = attacker.getStats().mana() / 10;
    
    // Total damage
    int totalDamage = baseDamage + manaBonus;
    
    // Consume 10 mana (this is important!)
    attacker.useMana(10);
    
    return totalDamage;
    }
}