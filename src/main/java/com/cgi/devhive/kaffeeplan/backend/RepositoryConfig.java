package com.cgi.devhive.kaffeeplan.backend;

import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Person.class);
    }
}