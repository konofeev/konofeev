package ru.konofeev.gui;

public enum Command
{
    CLEAR("clear"),
    GET("get"),
    EXIT("exit"),
    CREATE("create"),
    DELETE("delete"),
    FIND("find");

    private String name;

    Command(String name)
    {
        this.name = name;
    }
}
