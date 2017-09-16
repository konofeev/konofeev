package ru.konofeev.gui;

/**
 * Команды
 */
public enum Command
{
    /**
     * Очистить
     */
    CLEAR("clear"),
    /**
     * Получить
     */
    GET("get"),
    /**
     * Выход
     */
    EXIT("exit"),
    /**
     * Создать
     */
    CREATE("create"),
    /**
     * Удалить
     */
    DELETE("delete"),
    /**
     * Найти
     */
    FIND("find");

    /**                           
     * Наименование команы
     */
    private String name;

    /**
     * Установить команду
     *
     * @param name Наименование
     */
    Command(String name)
    {
        this.name = name;
    }
}
