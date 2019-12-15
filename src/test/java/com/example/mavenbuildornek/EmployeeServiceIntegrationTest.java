package com.example.mavenbuildornek;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DisplayName("Employee Service Integration Test")
class EmployeeServiceIntegrationTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeServiceImpl(employeeRepository);

        Employee ahmed = new Employee();
        ahmed.setName("Ahmed");

        Mockito.when(employeeRepository.findByName(ahmed.getName()))
                .thenReturn(Optional.of(ahmed));
    }

    @Test
    @DisplayName("When valid name, employee should be found")
    void getEmployee() {
        String name = "Ahmed";
        Employee found = employeeService.getEmployee(name);

        assertThat(found.getName()).isEqualTo(name);
    }
}