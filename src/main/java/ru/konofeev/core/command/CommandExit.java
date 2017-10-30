package ru.konofeev.core.command;

import java.util.List;
import java.util.ArrayList;
import javafx.application.Platform;
import ru.konofeev.core.Global;

public class CommandExit implements Command
{
    @Override
    public String getDescription()
    {
        return "Закрыть приложение";
    }

    @Override
    public String getName()
    {
        return "Выход";
    }

    @Override
    public List<String> getExamples()
    {
        List<String> examples = new ArrayList<String>();
        examples.add("exit");
        return examples;
    }

    @Override
    public boolean run()
    {
        Platform.exit();

        return true;
    }

    @Override
    public boolean checkCommand()
    {
        if ("exit".equalsIgnoreCase(Global.INSTANCE.getCommandLine().getText()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
