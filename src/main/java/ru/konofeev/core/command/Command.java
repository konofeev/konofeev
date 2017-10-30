package ru.konofeev.core.command;

import java.util.List;

/**
 * Команда
 */
public interface Command
{
    /**
     * Получить описание команды
     */
    String getDescription();

    /**
     * Получить наименование команды
     */
    String getName();

    /**
     * Получить список примеров использования
     *
     * @return Список примеров
     */
    List<String> getExamples();

    /**
     * Выполнить
     *
     * @return true, если команда выполнена успешно, иначе - false.
     */
    boolean run();

    /**
     * Проверка команды
     *
     * @return true, если команду нужно выполнить, иначе - false
     */
    boolean check();
}
