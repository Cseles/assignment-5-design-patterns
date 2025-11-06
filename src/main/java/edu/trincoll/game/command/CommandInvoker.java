package edu.trincoll.game.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Invoker for executing and managing commands.
 * Maintains command history for undo operations.
 *
 * This class demonstrates the Command pattern's ability to:
 * - Queue commands for execution
 * - Maintain history
 * - Support undo operations
 */
public class CommandInvoker {
    private final Stack<GameCommand> commandHistory = new Stack<>();

    /**
     * Executes a command and adds it to the command history.
     * 
     * This method demonstrates the Invoker's role in the Command pattern:
     * it executes commands without needing to know their implementation details.
     * 
     * @param command the command to execute
     */
    public void executeCommand(GameCommand command) {
        // Execute the command
        command.execute();
        
        // Add to history for potential undo
        commandHistory.push(command);
    }

    /**
     * Undoes the last executed command.
     * 
     * Removes the most recent command from history and calls its undo() method.
     * If the command history is empty, this method does nothing.
     * 
     * This demonstrates LIFO (Last In, First Out) undo behavior - the most
     * recent action is undone first.
     */
    public void undoLastCommand() {
        // Check if there are any commands to undo
        if (commandHistory.isEmpty()) {
            return;
        }
        
        // Pop the last command from history
        GameCommand command = commandHistory.pop();
        
        // Undo the command
        command.undo();
    }

    /**
     * Get the command history (for testing and logging).
     * 
     * @return a copy of the command history
     */
    public List<GameCommand> getCommandHistory() {
        return new ArrayList<>(commandHistory);
    }

    /**
     * Clear all command history.
     */
    public void clearHistory() {
        commandHistory.clear();
    }

    /**
     * Check if there are commands to undo.
     * 
     * @return true if there are commands in the history
     */
    public boolean hasCommandsToUndo() {
        return !commandHistory.isEmpty();
    }
}