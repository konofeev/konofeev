package ru.konofeev.entity;

/**
 * Сущность заметок
 */
public class Note
{
    /**
     * Идентификатор
     */
    private Integer identifier;

    /**
     * Заметка
     */
    private String message;

    /**
     * Получить идентификатор заметки
     *
     * @return Идентификатор
     */
    public Integer getIdentifier()
    {
        return identifier;
    }

    /**
     * Установить идентификатор
     *
     * @param identifier Идентификатор
     */
    public void setIdentifier(Integer identifier)
    {
        this.identifier = identifier;
    }

    /**
     * Получить заметку
     *
     * @return заметка
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Установить заметку
     *
     * @param message Заметка
     */
    public void setMessage(String message)
    {
        this.message = message;
    }
}
