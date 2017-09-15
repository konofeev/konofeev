package ru.konofeev;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import ru.konofeev.db.NoteService;
import ru.konofeev.entity.Note;
import static org.junit.Assert.*;

/**
 * Сущность заметок в БД
 */
public class TestNote
{
    private static final String NOTE_TEXT = "Заметка. Сигнатура999";

    @AfterClass
    public static void clearData() throws Exception
    {
        NoteService noteService = new NoteService();
        noteService.delete("сигнатура999");
    }

    /**
     * Создать заметку
     */
    @Test
    public void createNote() throws Exception
    {
        NoteService noteService = new NoteService();
        noteService.createNote(NOTE_TEXT);
    }

    /**
     * Получить заметки
     */
    @Test
    public void getNotes() throws Exception
    {
        NoteService noteService = new NoteService();
        List<Note> noteList = noteService.getNotes();
        assertNotNull(noteList);
    }

    /**
     * Найти заметку
     */
    @Test
    public void findNote() throws Exception
    {
        NoteService noteService = new NoteService();
        noteService.createNote(NOTE_TEXT);
        List<Note> noteList = noteService.find("заметка");
        assertNotNull(noteList);
        assertNotNull(noteList.get(0));
        assertNotNull(noteList.get(0).getIdentifier());
        assertNotNull(noteList.get(0).getNote());
    }

    /**
     * Получить заметку
     */
    @Test
    public void getNote() throws Exception
    {
        NoteService noteService = new NoteService();
        noteService.createNote(NOTE_TEXT + " uniquiSignatureNote");
        Integer identifierNote = noteService.find("uniquiSignatureNote").get(0).getIdentifier();
        Note note = noteService.getNote(identifierNote);
        assertNotNull(note);
    }

    /**
     * Удалить заметку
     */
    @Test
    public void deleteNote() throws Exception
    {
        NoteService noteService = new NoteService();
        noteService.createNote(NOTE_TEXT + " uniquiSignatureNoteForDelete Сигнатура999");
        Integer identifierNote = noteService.find("uniquiSignatureNoteForDelete").get(0).getIdentifier();
        noteService.delete(identifierNote);
        assertNull(noteService.getNote(identifierNote));
    }
}
