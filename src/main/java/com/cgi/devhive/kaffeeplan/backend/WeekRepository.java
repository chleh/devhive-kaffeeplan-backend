package com.cgi.devhive.kaffeeplan.backend;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "weeks", path = "weeks")
public interface WeekRepository extends PagingAndSortingRepository<KaffeeplanEntry, String> {
    // List<KaffeeplanEntry> findByName(@Param("name") String name);
}
