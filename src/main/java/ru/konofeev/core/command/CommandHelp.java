package ru.konofeev.core.command;

import ru.konofeev.core.Global;

import java.util.ArrayList;
import java.util.List;

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
        List<String> examples = new ArrayList<>();
        examples.add("help");
        return examples;
    }

    @Override
    public boolean run()
    {
        StringBuilder help = new StringBuilder();
        List<Command> commandList = Global.INSTANCE.getCommandManager().getCommandList();
        for (Command command: commandList)
        {
            help.append("<h2>").append(command.getName()).append("</h2>");
            help.append("<p>").append(command.getDescription()).append("</p>");
            help.append("<p>");
            for (String example: command.getExamples())
            {
                help.append(example).append("<br>");
            }
            help.append("</p>");
        }
        Global.INSTANCE.getEditor().setHtmlText(help.toString());
        return true;
    }

    @Override
    public boolean check()
    {
        return "help".equalsIgnoreCase(Global.INSTANCE.getCommandLine().getText());
    } 

    @Override
    public List<String> getAdditionalParameters()
    {
        return new ArrayList<>();
    }
}
