package test.demo.spring.core.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.demo.spring.core.dto.CarDto;
import test.demo.spring.core.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;


    @Autowired

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public ResponseEntity<List<CarDto>> getAllCars() {
        final List<CarDto> allCars = carService.getAllCars();
        return ResponseEntity.ok().body(allCars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable("id") Long id) {
        final CarDto singleCar = carService.getSingleCar(id);
        return ResponseEntity.ok().body(singleCar);
    }

    @PostMapping
    public ResponseEntity<Object> createCar(@RequestBody CarDto carDto) {
        carService.addNewCar(carDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Object> updateCar(@RequestBody CarDto carDto) {
        carService.addNewCar(carDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delateCar(@PathVariable("id") Long id){
        carService.removeCar(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/test")
    public ResponseEntity<Object> getCar(){
        carService.testExternaService();
        return ResponseEntity.ok().build();
    }
}