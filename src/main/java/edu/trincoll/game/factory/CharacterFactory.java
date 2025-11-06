package edu.trincoll.game.factory;

import edu.trincoll.game.model.Character;
import edu.trincoll.game.model.CharacterStats;
import edu.trincoll.game.model.CharacterType;
import edu.trincoll.game.strategy.*;

/**
 * AI Collaboration Summary:
 * Tool: ChatGPT (GPT-5)
 *
 * What AI Helped With:
 * 1. Guided the implementation of all factory methods (createWarrior, createMage, createArcher, createRogue, createCharacter).
 * 2. Suggested correct use of the Builder pattern (Character.builder()) for character creation.
 * 3. Clarified the correct stat configurations and attack/defense strategy pairings for each character type.
 * 4. Explained how to implement the switch expression in createCharacter() using modern Java syntax (Java 21).
 *
 * What I Had to Fix or Finalize Manually:
 * 1. Verified and aligned character stat values (HP, ATK, DEF, MANA) with assignment requirements.
 * 2. Ensured each builder call chained properly and returned a fully configured Character instance.
 * 3. Fixed test failures related to missing IllegalArgumentException for null CharacterType.
 *
 * What I Learned:
 * - How the Factory Method pattern simplifies complex object creation by encapsulating configuration logic.
 * - How to use builder chaining to make object construction cleaner and more readable.
 * - How to apply Java 21 switch expressions for flexible and maintainable factory logic.
 *
 * Task: Taha Moula
 */

/**
 *
 * Factory for creating pre-configured characters.
 * Demonstrates the Factory Method pattern for object creation.
 *
 * This class provides static factory methods that create characters
 * with appropriate stats and strategies for their type.
 */
public class CharacterFactory {

    // TODO 2a: Implement createWarrior()
    public static Character createWarrior(String name) {
        return Character.builder()
                .name(name)
                .type(CharacterType.WARRIOR)
                .stats(CharacterStats.create(150, 40, 30, 0))
                .attackStrategy(new MeleeAttackStrategy())
                .defenseStrategy(new HeavyArmorDefenseStrategy())
                .build();
    }

    // TODO 2b: Implement createMage()
    public static Character createMage(String name) {
        return Character.builder()
                .name(name)
                .type(CharacterType.MAGE)
                .stats(CharacterStats.create(80, 60, 10, 100))
                .attackStrategy(new MagicAttackStrategy())
                .defenseStrategy(new StandardDefenseStrategy())
                .build();
    }

    // TODO 2c: Implement createArcher()
    public static Character createArcher(String name) {
        return Character.builder()
                .name(name)
                .type(CharacterType.ARCHER)
                .stats(CharacterStats.create(100, 50, 15, 20))
                .attackStrategy(new RangedAttackStrategy())
                .defenseStrategy(new StandardDefenseStrategy())
                .build();
    }

    // TODO 2d: Implement createRogue()
    public static Character createRogue(String name) {
        return Character.builder()
                .name(name)
                .type(CharacterType.ROGUE)
                .stats(CharacterStats.create(90, 55, 20, 30))
                .attackStrategy(new MeleeAttackStrategy())
                .defenseStrategy(new StandardDefenseStrategy())
                .build();
    }

    // TODO 2e: Implement createCharacter()
    public static Character createCharacter(String name, CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException("Character type cannot be null");
        }

        return switch (type) {
            case WARRIOR -> createWarrior(name);
            case MAGE    -> createMage(name);
            case ARCHER  -> createArcher(name);
            case ROGUE   -> createRogue(name);
        };
    }
}