package ru.konofeev.db;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import ru.konofeev.entity.Note;
import java.text.MessageFormat;

/**
 * Сервис заметок
 */
public class NoteService extends DataBaseService
{
    private final static String CREATE_TABLE = "create table if not exists `note` ( `identifier` integer primary key autoincrement not null , `note` varchar(4096) not null, `note_upper` varchar(4096) not null);";

    private final static String CREATE_INDEX = "create index if not exists NoteTextValue on `Note`(`note_upper`)";

    private final static String INSERT = "insert into note (note, note_upper) values (''{0}'', ''{1}'')";

    private final static String SELECT = "select identifier, note from note";

    private final static String SELECT_BY_IDENTIFIER = "select identifier, note from note where identifier = {0}";

    private final static String SELECT_BY_NOTE = "select identifier, note from note where note_upper like ''%{0}%''";

    private final static String DELETE_BY_IDENTIFIER = "delete from note where identifier = {0}";

    private final static String DELETE_BY_FIND_TEXT = "delete from note where note_upper like ''%{0}%''";

    /**
     * Конструктор
     */
    public NoteService() throws Exception
    {
        initialize();
    }

    /**
     * Инициализация
     * Создаётся таблица и индекс, если их не было
     */
    public void initialize() throws Exception
    {
        getStatement().executeUpdate(CREATE_TABLE);
        getStatement().executeUpdate(CREATE_INDEX);
    }

    /**
     * Создать заметку
     *
     * @param note Заметка
     */
    public void createNote(String note) throws Exception
    {
        getStatement().executeUpdate(MessageFormat.format(INSERT, note, note.toUpperCase()));
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
            resultSet = getStatement().executeQuery(SELECT);
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
            resultSet = getStatement().executeQuery(MessageFormat.format(SELECT_BY_IDENTIFIER, identifier));
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
            resultSet = getStatement().executeQuery(MessageFormat.format(SELECT_BY_NOTE, findText.toUpperCase()));
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
        getStatement().executeUpdate(MessageFormat.format(DELETE_BY_IDENTIFIER, identifier));
    }

    /**
     * Удалить заметки по подстроке
     *
     * @param substringForDelete Подстрока по которой удаляются заметки
     */
    public void delete(String substringForDelete) throws Exception 
    {
        getStatement().executeUpdate(MessageFormat.format(DELETE_BY_FIND_TEXT, substringForDelete.toUpperCase()));
    }
}
