package ru.konofeev.gui;

/**
 * Команда выхода
 */
public class CommandExit implements CommandBase
{
    private static final String EXIT = "exit";

    @Override
    public void run(String commandText, MainWindow mainWindow)
    {
        if (EXIT.equalsIgnoreCase(commandText))
        {
            System.exit(0);
        }
    }
}
