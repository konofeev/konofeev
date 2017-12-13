package ru.konofeev.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Парсер команд
 */
public class ParserCommand
{
    private String commandSource;
    private static final String PATTERN = "^(\\w+)\\s(.*$)";
    private String command;
    private String value;

    /**
     * Конструктор
     *
     * @param commandSource Команда с параметрами
     */
    public ParserCommand(String commandSource)
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

    private void parse()
    {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(commandSource);
        if (matcher.find())
        {
            command = matcher.group(0);
            value = matcher.group(1);
        }
    }
}
