package test.demo.spring.core.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import test.demo.spring.core.controller.CarController;
import test.demo.spring.core.conventer.CarConventer;
import test.demo.spring.core.dto.CarDto;
import test.demo.spring.core.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private RestTemplate restTemplate;

    public CarService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final Car car1 = new Car(1L, "bmw", "e1", 22, 2, "róż");
    private final Car car2 = new Car(2L, "merc", "g4", 24, 3, "czerwony");
    private final Car car3 = new Car(3L, "tojota", "h3", 25, 4, "żółty");
    private final Car car4 = new Car(4L, "brumbrum", "gjh", 27, 5, "czarny");
    private final Car car5 = new Car(5L, "opel", "r3", 22, 4, "biały");
    private final List<Car> carList = new ArrayList<>(Arrays.asList(car1, car2, car3, car4, car5));

    public List<CarDto> getAllCars() {
        return carList
                .stream()
                .map(CarConventer::mapToDto)
                .collect(Collectors.toList());
    }

    public CarDto getSingleCar(Long id){
        final Car carById = getCarById(id);

        return CarConventer.mapToDto(carById);
        //final Optional<Car> first = carList.stream().filter(car->car.getId().equals(id)).findFirst();
        // return first.map(CarConverter::mapFromDto).get();
    }

    private Car getCarById(Long id) {
        for (Car car : carList){
            if (id.equals(car.getId())){
                return car;
            }
        }
        System.out.println("No car with given id: " + id);
        return null;
    }

    public void addNewCar(CarDto newCar){
        final Car car = CarConventer.mapFromDto(newCar);
        carList.add(car);
    }

    public void updateCar(CarDto carDto){
        final Car carById = getCarById(carDto.getId());
        if (carById != null){
            carById.setBrand(carDto.getBrand());
            carById.setColor(carDto.getColor());
            carById.setModel(carDto.getModel());
            carById.setSeats(carDto.getSeats());
            carById.setHorsePower(carDto.getHorsePower());
        }
    }

    public void removeCar(Long id){
        carList.remove(getCarById(id));
        System.out.println("Car remove");
    }

    public void testExternaService(){
        final ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:9090/api/test", String.class);
        System.out.println("Extermal servise returned:" + forEntity.getBody());
    }
}
