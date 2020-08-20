package test.spring.dependency.injection.example;

import lombok.Getter;
import test.spring.dependency.injection.example.model.Floar;
import test.spring.dependency.injection.example.model.Roof;
import test.spring.dependency.injection.example.model.Wall;

@Getter
public class ShopID {
    private Floar floar;
    private Wall wall;
    private Roof roof;

    public ShopID(Floar floar, Wall wall, Roof roof) {
        this.floar = floar;
        this.wall = wall;
        this.roof = roof;
    }
}
