package ru.konofeev.core;

import org.junit.Assert;
import org.junit.Test;
import ru.konofeev.exception.ParseException;
import java.util.logging.Logger;

/**
 * Тестирование парсера команд
 */
public class ParserCommandTest
{
    private static final Logger LOG = Logger.getLogger(ParserCommandTest.class.getName());

    /**
     * Проверка существования сущности
     */
    @Test
    public void exists() throws Exception
    {
        ParserCommand parser = new ParserCommand("command");
        Assert.assertNotNull(parser);
    }

    /**
     * Разбор одной команды
     */
    @Test
    public void parseOnlyOneCommand() throws Exception
    {
        String command = "exampleCommand";
        ParserCommand parser = new ParserCommand(command);
        Assert.assertNotNull(parser.getCommand());
        Assert.assertEquals(command, parser.getCommand());
    }

    /**
     * Проверка некорректного имени команды
     */
    @Test(expected = ParseException.class)
    public void parseOnOneCommandIncorrectName() throws Exception
    {
        String incorrectCommand = "example!incorrect+command";
        ParserCommand parser = new ParserCommand(incorrectCommand);
    }

    /**
     * Разбор команды со значением
     */
    @Test
    public void parseCommandWithValue() throws Exception
    {
        String command = "exampleCommand";
        String value = "value1 value2 3 5";
        ParserCommand parser = new ParserCommand(command + " " + value);
        Assert.assertNotNull(parser.getCommand());
        Assert.assertNotNull(parser.getValue());
        Assert.assertTrue(command.equals(parser.getCommand()));
        Assert.assertTrue(value.equals(parser.getValue()));
    }

    /**
     * Разбор команды со значением
     */
    @Test
    public void parseCommandWithOtherValue() throws Exception
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
