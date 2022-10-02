package ru.geeekbains.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component // инициализация бина
@Scope("prototype") // singleton , prototype
public class Box {
    private String color;

    public Box() {
    }

    public Box(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @PostConstruct // задает по умолчанию
    public void init()
    {
        this.color="Yello";
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Box{" +
                "color='" + color + '\'' +
                '}';
    }


}
