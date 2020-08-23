package test.demo.spring.core.person;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Backpack {

    private int capacity = 2;
    private int myObject = 3;
}
