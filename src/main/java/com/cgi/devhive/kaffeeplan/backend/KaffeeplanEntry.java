package com.cgi.devhive.kaffeeplan.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KaffeeplanEntry {
    @Id
    String yearWeek;
    String name;
    String email;
}
