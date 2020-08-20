package test.spring.dependency.injection.example;


import lombok.Getter;
import test.spring.dependency.injection.example.model.Floar;
import test.spring.dependency.injection.example.model.Roof;
import test.spring.dependency.injection.example.model.Wall;

@Getter
public class Shop {


    private Floar floar;
    private Wall wall;
    private Roof roof;

    public Shop(){
        this.floar= new Floar("red",100,5);
        this.wall = new Wall(5, "white");
        this.roof = new Roof(100);
    }
}
