package com.eduit.service.repository;

import com.eduit.service.action.CarAction;
import com.eduit.service.model.Car;
import com.eduit.service.resource.response.AutoResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class CarActionTest {
    public static final String FIAT = "fiat";
    public static final String PALIO = "palio";
    public static final Double PRICE = 454545D;

    private  CarRepository carRepository;
    private CarRepository carRepositoryFail;

    @Before
    public void init(){
        carAction = new CarAction(new CarRepository() {
            @Override
            public <S extends Car> S save(S s) {
                return null;
            }

            @Override
            public <S extends Car> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Car> findById(Long aLong) {
                Car car = new Car(1L, FIAT, PALIO, PRICE);
                return Optional.of(car);
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Car> findAll() {
                return null;
            }

            @Override
            public Iterable<Car> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Car car) {

            }

            @Override
            public void deleteAll(Iterable<? extends Car> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        }
    }

    @Test
    public  void aaaaa(){
        CarAction carAction = new CarAction(carRepository);

    }
}
