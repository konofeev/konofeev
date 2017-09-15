package ru.konofeev;

import java.util.List;
import org.junit.Test;
import ru.konofeev.core.Main;
import static org.junit.Assert.*;

/**
 * Тестирование
 */
public class TestCore
{
    private static final String NOTE_FIRST = "Первая заметка";
    private static final String NOTE_OTHER = "Другая заметка";

    /**
     * Создать заметку
     */
    @Test
    public void createNote()
    {
        Integer noteIdentifier = Main.createNote(NOTE_FIRST);
        assertTrue(noteIdentifier > 0);
    }

    /**
     * Получить заметку
     */
    @Test
    public void getNote()
    {
         String note = Main.getNote(Main.createNote(NOTE_FIRST));
         //assertEquals(note, NOTE_FIRST);
    }

    /**
     * Получить заметку
     * Негативный сценарий
     */
    @Test
    public void getNoteNegative()
    {
        String note = Main.getNote(Main.createNote(NOTE_FIRST));
        //assertNotEquals(note, NOTE_OTHER);
    }
}
