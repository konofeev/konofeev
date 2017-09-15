package ru.konofeev.db;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import ru.konofeev.entity.Note;

/**
 * Сущность заметок
 */
public class NoteService extends DataBaseService
{
    public NoteService() throws Exception
    {
        initialize();
    }

    /**
     * Инициализация
     * Создаётся таблица, если её не было
     */
    public void initialize() throws Exception
    {
        getStatement().executeUpdate("create table if not exists `note` ( `identifier` integer primary key autoincrement not null , `note` varchar(4096) not null, `note_upper` varchar(4096) not null);");
        getStatement().executeUpdate("create index if not exists NoteTextValue on `Note`(`note_upper`)");
    }

    /**
     * Создать заметку
     *
     * @param note Заметка
     */
    public void createNote(String note) throws Exception
    {
        getStatement().executeUpdate("insert into note (note, note_upper) values ('" + note + "', '" + note.toUpperCase() + "')");
    }

    /**
     * Полчить список заметок
     *
     * @return Список заметок
     */
    public List<Note> getNotes() throws Exception
    {
        List<Note> result = new ArrayList<>();
        ResultSet resultSet = null;
        Note note = null;
        try 
        {
            resultSet = getStatement().executeQuery("select identifier, note from note");
            while (resultSet.next()) 
            {
                note = new Note();
                note.setIdentifier(resultSet.getInt(1));
                note.setNote(resultSet.getString(2));
                result.add(note);
            }
        }
        finally 
        {
            resultSet.close();
            return result;
        }
    }                                 

    /**
     * Полчить заметку
     *
     * @param identifier Идентификатор заметки
     *
     * @return Заметка
     */
    public Note getNote(Integer identifier) throws Exception
    {
        Note result = null;
        ResultSet resultSet = null;
        try 
        {
            resultSet = getStatement().executeQuery("select identifier, note from note where identifier = " + identifier);
            if (resultSet.next()) 
            {
                result = new Note();
                result.setIdentifier(resultSet.getInt(1));
                result.setNote(resultSet.getString(2));
            }
        }
        finally 
        {
            resultSet.close();
            return result;
        }
    }                                 

    /**
     * Найти заметку
     * Поиск выполняет по подстроке регистронезависимо
     *
     * @param findText Текст для поиск.
     *
     * @return Список найденных заметок
     */
    public List<Note> find(String findText) throws Exception
    {
        List<Note> result = new ArrayList<>();
        ResultSet resultSet = null;
        Note note = null;
        try 
        {
            resultSet = getStatement().executeQuery("select identifier, note from note where note_upper like '%" + findText.toUpperCase() + "%'");
            while (resultSet.next()) 
            {
                note = new Note();
                note.setIdentifier(resultSet.getInt(1));
                note.setNote(resultSet.getString(2));
                result.add(note);
            }
        }
        finally 
        {
            resultSet.close();
            return result;
        }
    }

    /**
     * Удалить заметку
     *
     * @param identifier Идентификатор заметки
     */
    public void delete(Integer identifier) throws Exception
    {
        getStatement().executeUpdate("delete from note where identifier = " + identifier);
    }

    /**
     * Удалить заметки по подстроке
     *
     * @param substringForDelete Подстрока по которой удаляются заметки
     */
    public void delete(String substringForDelete) throws Exception 
    {
        getStatement().executeUpdate("delete from note where note_upper like '%" + substringForDelete.toUpperCase() + "%'");
    }
}
