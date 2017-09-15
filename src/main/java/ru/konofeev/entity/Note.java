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

    public Integer getIdentifier()
    {
        return identifier;
    }
    public void setIdentifier(Integer identifier)
    {
        this.identifier = identifier;
    }
    public String getNote()
    {
        return note;
    }
    public void setNote(String note)
    {
        this.note = note;
    }
}
