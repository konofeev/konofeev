package ru.konofeev.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Основной класс 
 */
public class Main
{
    /**
     * Точка входа
     *
     * @param arguemnts Аргументы командной строки
     */
    public static void main(String[] arguments) throws Exception
    {
    }                                 

    /**
     * Создать заметку
     *
     * @param note Заметка
     *
     * @return Идентификатор созданной заметки
     */
    public static Integer createNote(String note)
    {
        return 1;
    }

    /**
     * Получить заметку
     *
     * @param noteIdentifier Идентификатор заметки
     * * @return Заметка
     */
    public static String getNote(Integer noteIdentifier)
    {
        return "Заметка 1";
    }
}
