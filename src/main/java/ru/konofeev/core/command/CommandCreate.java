package ru.konofeev.core.command;

import java.util.List;
import java.util.ArrayList;
import ru.konofeev.core.Global;

public class CommandCreate implements Command
{
    @Override
    public String getDescription()
    {
        return "Создать заметку";
    }

    @Override
    public String getName()
    {
        return "Создание";
    }

    @Override
    public List<String> getExamples()
    {
        List<String> examples = new ArrayList<String>();
        examples.add("create <text note>");
        return examples;
    }

    @Override
    public boolean run()
    {
        Global.INSTANCE.getEditor().setHtmlText("");
        return true;
    }

    @Override
    public boolean check()
    {
        if ("create".equalsIgnoreCase(Global.INSTANCE.getCommandLine().getText()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public List<String> getAdditionalParameters()
    {
        return new ArrayList<String>();
    }
}
