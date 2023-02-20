package com.right.above.livecornercase.data.dto;

import com.right.above.livecornercase.data.Animal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnimalDto {
    private Animal animal;
    private String storage;
}
