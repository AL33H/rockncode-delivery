package br.com.rockncodedelivery.external.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressComponent {
    private String long_name;
    private String short_name;
    private ArrayList<String> types;
}
