package com.eduit.service.action;

import com.eduit.service.exceptions.NotFoundException;
import com.eduit.service.model.Car;
import com.eduit.service.repository.CarRepository;
import com.eduit.service.resource.response.AutoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@Component es igual
public class CarAction {
    private CarRepository carRepository;

    @Autowired
    public CarAction(CarRepository carRepository){
        this.carRepository= carRepository;
    }

    public AutoResponse getCarById(Long id){
        Optional<Car> carOpc = carRepository.findById(id);
        Car car = carOpc.orElseThrow(()->new NotFoundException("Car id " + id + " not found"));
        return new AutoResponse(car.getId(), car.getBrand(), car.getModel(), car.getPrice());
    }
}
