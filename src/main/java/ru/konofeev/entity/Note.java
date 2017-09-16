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
    private String note;

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
    public String getNote()
    {
        return note;
    }

    /**
     * Установить заметку
     *
     * @param note Заметка
     */
    public void setNote(String note)
    {
        this.note = note;
    }
}
