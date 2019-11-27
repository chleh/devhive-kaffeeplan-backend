package com.cgi.devhive.kaffeeplan.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KaffeeplanEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_gen")
    @GenericGenerator(name = "my_gen",
            strategy = "com.cgi.devhive.kaffeeplan.backend.YearWeekSequenceGenerator"
            /*parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "B_"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") }*/)
    String yearWeek;
    String name;
    String email;
}
