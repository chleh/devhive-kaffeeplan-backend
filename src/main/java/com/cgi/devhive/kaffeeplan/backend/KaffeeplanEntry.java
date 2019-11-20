package com.cgi.devhive.kaffeeplan.backend;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class KaffeeplanEntry {
    @Id
    final String yearWeek;
    String name;
    String email;
}
