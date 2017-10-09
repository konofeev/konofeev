package ru.konofeev.gui;

/**
 * Очистка
 */
public class CommandClear implements CommandBase
{
    private static final String CLEAR = "clear";

    @Override
    public void run(String commandText, MainWindow mainWindow)
    {
        if (CLEAR.equalsIgnoreCase(commandText))
        {
            mainWindow.getMainArea().setText("");
        }
    }
}
