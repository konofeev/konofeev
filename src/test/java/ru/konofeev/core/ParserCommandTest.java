package ru.konofeev.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тестирование парсера команд
 */
public class ParserCommandTest
{
    /**
     * Проверка существования сущности
     */
    @Test
    public void exists()
    {
        ParserCommand parser = new ParserCommand("command");
        Assert.assertNotNull(parser);
    }

    /**
     * Разбор одной команды
     */
    @Test
    public void parseOnlyOneCommand()
    {
        String command = "example-command";
        ParserCommand parser = new ParserCommand(command);
        Assert.assertNotNull(parser.getCommand());
        Assert.assertEquals(command, parser.getCommand());
    }

    /**
     * Разбор команды со значением
     */
    @Test
    public void parseCommandWithValue()
    {
        String command = "example-command";
        String value = "value1 value2 3 5";
        ParserCommand parser = new ParserCommand(command + " " + value);
        Assert.assertNotNull(parser.getCommand());
        Assert.assertNotNull(parser.getValue());
        Assert.assertEquals(command, parser.getCommand());
        Assert.assertEquals(value, parser.getValue());
    }

    /**
     * Разбор команды со значением
     */
    @Test
    public void parseCommandWithOtherValue()
    {
        String command = "create";
        String value = "This new note for test!";
        ParserCommand parser = new ParserCommand(command + " " + value);
        Assert.assertNotNull(parser.getCommand());
        Assert.assertNotNull(parser.getValue());
        Assert.assertEquals(command, parser.getCommand());
        Assert.assertEquals(value, parser.getValue());
    }
    
}
