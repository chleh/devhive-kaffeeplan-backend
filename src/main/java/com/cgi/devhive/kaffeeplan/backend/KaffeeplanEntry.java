package com.cgi.devhive.kaffeeplan.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class KaffeeplanEntry {
    int year;
    int week;
    String name;
    String email;
}
