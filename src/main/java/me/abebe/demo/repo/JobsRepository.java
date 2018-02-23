package me.abebe.demo.repo;

import me.abebe.demo.model.Jobs;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobsRepository extends CrudRepository<Jobs,Long> {
    List<Jobs> findByPostedBy(String postedBy);
    List<Jobs> findDistinctByOrganization(String organization);
}
