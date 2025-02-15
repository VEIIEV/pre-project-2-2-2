package org.example.preproject222;

import org.example.preproject222.config.CarProperties;
import org.example.preproject222.dao.CarDao;
import org.example.preproject222.entity.Car;
import org.example.preproject222.service.CarService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class) // Подключаем поддержку Mockito
class PreProject222ApplicationTests {



    @Mock
    CarDao carDao;

    @Spy
    private CarProperties carProperties = new CarProperties();

    @Mock
    private CarProperties.Limiter limiter; // Добавляем мок для Limiter

    @InjectMocks
    CarService carService;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        Mockito.when(carProperties.getLimiter()).thenReturn(limiter);
        Mockito.when(limiter.getMaxValue()).thenReturn(5);

        List<Car> toReturn = new ArrayList<>();
        Mockito.lenient().when(carDao.getSpecifiedCarAmount(25, null)).thenReturn(toReturn);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();  // Закрытие моков после теста
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testCarService() {
        Assertions.assertTrue(carService.getSpecifiedCarsAmount(25, null).isEmpty(), "list is NOT empty");

    }

}
