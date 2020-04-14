package org.openjfx;

public class Artikel
{
    private int id;
    private String name;
    private String geschäft;

    public Artikel(int id, String name, String store)
    {
        this.id = id;
        this.name = name;
        this.geschäft = store;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGeschäft()
    {
        return geschäft;
    }

    public void setGeschäft(String geschäft)
    {
        this.geschäft = geschäft;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
