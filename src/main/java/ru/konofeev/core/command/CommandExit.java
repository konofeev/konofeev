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
        List<String> examples = new ArrayList<>();
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
    public boolean check()
    {
        return "exit".equalsIgnoreCase(Global.INSTANCE.getCommandLine().getText());
    }

    @Override
    public List<String> getAdditionalParameters()
    {
        return new ArrayList<>();
    }
}
