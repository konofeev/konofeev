package ru.konofeev.core.command;

import java.util.List;
import java.util.ArrayList;
import ru.konofeev.core.Global;
import ru.konofeev.entity.Note;

public class CommandNote implements Command
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
        List<String> examples = new ArrayList<String>();
        examples.add("get");
        return examples;
    }

    @Override
    public boolean run()
    {
        String noteString = "";
        List<Note> noteList = new ArrayList<Note>();
        //Global.INSTANCE.getEditor().setHtmlText("");
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
            noteString = noteString + note.getNote() + "<br>";
        }
        Global.INSTANCE.getEditor().setHtmlText(noteString);

        return true;
    }

    @Override
    public boolean check()
    {
        if ("get".equalsIgnoreCase(Global.INSTANCE.getCommandLine().getText()))
        {
            return true;
        }
        else
        {
            return false;
        }
    } 
}
