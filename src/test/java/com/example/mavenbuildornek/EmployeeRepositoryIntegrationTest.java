package com.example.mavenbuildornek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@DisplayName("Employee Repository Integration Test")
class EmployeeRepositoryIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @Sql("classpath:createEmployee.sql")
    @DisplayName("When findByName then return Employee")
    void findByName() {
        String name = "Ahmed Yasir";

        Employee found = employeeRepository.findByName(name)
                .orElseGet(Employee::new);

        assertThat(found.getName()).isEqualTo(name);
    }
}