package com.br.luminous.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillFileResponse {
    private String url;
    private String name;
    private Long size;
}
