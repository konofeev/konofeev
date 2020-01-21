package ru.konofeev.core.command;

import java.util.List;
import java.util.ArrayList;
import ru.konofeev.core.Global;
import ru.konofeev.entity.Note;

public class CommandGet implements Command
{    
    @Override
    public String getDescription()
    {
        return "Получение заметок";
    }

    @Override
    public String getName()
    {
        return "Получение";
    }

    @Override
    public List<String> getExamples()
    {
        List<String> examples = new ArrayList<>();
        examples.add("get");
        return examples;
    }

    @Override
    public boolean run()
    {
        StringBuilder noteString = new StringBuilder();
        List<Note> noteList;
        try
        {
            noteList = Global.INSTANCE.getNoteService().getNotes();
        }
        catch (Exception exception)
        {
            Global.INSTANCE.getEditor().setHtmlText("Ошибка получения заметок");
            return false;
        }
        for (Note note: noteList)
        {
            noteString.append(note.getMessage()).append("<br>");
        }
        Global.INSTANCE.getEditor().setHtmlText(noteString.toString());

        return true;
    }

    @Override
    public boolean check()
    {
        return "get".equalsIgnoreCase(Global.INSTANCE.getCommandLine().getText());
    } 

    @Override
    public List<String> getAdditionalParameters()
    {
        return new ArrayList<>();
    }
}
