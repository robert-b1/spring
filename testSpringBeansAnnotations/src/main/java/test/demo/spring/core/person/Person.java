package test.demo.spring.core.person;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Person {

    private Backpack backpack;

    @Autowired

    public Person(Backpack backpack) {
        this.backpack = backpack;
    }
}
