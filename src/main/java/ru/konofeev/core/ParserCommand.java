package ru.konofeev.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.konofeev.exception.ParseException;

/**
 * Парсер команд
 * Разделителем команд и значения считаем пробельные символы
 * Команда состоит из букв и цифр
 */
public class ParserCommand
{
    private String commandSource;
    private static final String PATTERN = "^(\\w+)(\\s(.*))*$";
    private String command;
    private String value;

    /**
     * Конструктор
     *
     * @param commandSource Команда с параметрами
     */
    public ParserCommand(String commandSource) throws ParseException
    {
        this.commandSource = commandSource;
        parse();
    }

    /**
     * Вернуть комманду
     *
     * @return Команда
     */
    public String getCommand()
    {
        return command;
    }

    /**
     * Вернуть значение
     */
    public String getValue()
    {
        return value;
    }

    private void parse() throws ParseException
    {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(commandSource);
        if (matcher.find())
        {
            setCommand(matcher.group(1));
            setValue(matcher.group(2));
        }
        else
        {
            throw new ParseException("Ошибка разбора запроса команды.");
        }
    }

    private void setCommand(String command)
    {
        if (command != null)
        {
            this.command = command.trim();
        }
    }

    private void setValue(String value)
    {
        if (value != null)
        {
            this.value = value.trim();
        }
    }
}
