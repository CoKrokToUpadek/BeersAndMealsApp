package com.cokroktoupadek.beersandmealsbackend.domain.dto.meals.api_request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MealsApiDto {
    @JsonProperty("meals")
    private List<SingleMealApiDto> singleMealDtoList;
}
