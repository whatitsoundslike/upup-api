package com.grapheople.core.api.controller.v1.request;

import com.grapheople.core.domain.ExampleData;

public record ExampleRequestDto(String data) {
    public ExampleData toExampleData() {
        return new ExampleData(data, data);
    }
}
