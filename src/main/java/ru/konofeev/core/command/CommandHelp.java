package ru.konofeev.core.command;

import java.util.List;
import java.util.ArrayList;
import ru.konofeev.core.Global;
import ru.konofeev.entity.Note;

public class CommandHelp implements Command
{    
    @Override
    public String getDescription()
    {
        return "Получение справки. По умолчанию отображается список доступных команд";
    }

    @Override
    public String getName()
    {
        return "Справка";
    }

    @Override
    public List<String> getExamples()
    {
        List<String> examples = new ArrayList<String>();
        examples.add("help");
        return examples;
    }

    @Override
    public boolean run()
    {
        String help = "";
        List<Command> commandList = Global.INSTANCE.getCommandManager().getCommandList();
        for (Command command: commandList)
        {
            help = help + "<h2>" + command.getName() + "</h2>";
            help = help + "<p>" + command.getDescription() + "</p>";
            help = help + "<p>";
            for (String example: command.getExamples())
            {
                help = help + example + "<br>";
            }
            help = help + "</p>";
        }
        Global.INSTANCE.getEditor().setHtmlText(help);
        return true;
    }

    @Override
    public boolean check()
    {
        if ("help".equalsIgnoreCase(Global.INSTANCE.getCommandLine().getText()))
        {
            return true;
        }
        else
        {
            return false;
        }
    } 
}
