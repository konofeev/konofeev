package ru.konofeev.core.command;

import java.util.List;
import java.util.ArrayList;
import ru.konofeev.core.Global;

public class CommandClear implements Command
{
    @Override
    public String getDescription()
    {
        return "Очистить текстовую область";
    }

    @Override
    public String getName()
    {
        return "Очистка";
    }

    @Override
    public List<String> getExamples()
    {
        List<String> examples = new ArrayList<String>();
        examples.add("clear");
        return examples;
    }

    @Override
    public boolean run()
    {
        Global.INSTANCE.getEditor().setHtmlText("");
        return true;
    }

    @Override
    public boolean checkCommand()
    {
        if ("clear".equalsIgnoreCase(Global.INSTANCE.getCommandLine().getText()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
