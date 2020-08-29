package test.demo.spring.core.conventer;

import test.demo.spring.core.dto.CarDto;
import test.demo.spring.core.model.Car;

public class CarConventer {

    public static CarDto mapToDto(Car car){
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getHorsePower(),
                car.getSeats(),
                car.getColor()
        );
    }

    public static Car mapFromDto(CarDto carDto){
        return new Car(
                carDto.getId(),
                carDto.getBrand(),
                carDto.getModel(),
                carDto.getHorsePower(),
                carDto.getSeats(),
                carDto.getColor()
        );
    }
}
