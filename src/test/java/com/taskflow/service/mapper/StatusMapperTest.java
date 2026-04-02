package com.taskflow.service.mapper;

import static com.taskflow.domain.StatusAsserts.*;
import static com.taskflow.domain.StatusTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatusMapperTest {

    private StatusMapper statusMapper;

    @BeforeEach
    void setUp() {
        statusMapper = new StatusMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getStatusSample1();
        var actual = statusMapper.toEntity(statusMapper.toDto(expected));
        assertStatusAllPropertiesEquals(expected, actual);
    }
}
