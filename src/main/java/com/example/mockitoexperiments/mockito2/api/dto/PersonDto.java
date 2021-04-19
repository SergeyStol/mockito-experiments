package com.example.mockitoexperiments.mockito2.api.dto;

import lombok.*;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    long id;
    String name;
}
