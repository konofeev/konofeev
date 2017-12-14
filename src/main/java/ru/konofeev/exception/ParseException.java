package ru.konofeev.exception;

/**
 * Ошибка парсера команд
 */
public class ParseException extends Exception
{
    /**
     * Конструктор
     *
     * @param message Сообщение
     */
    public ParseException(String message)
    {
        super(message);
    }
}
