package me.abebe.demo.repo;

import me.abebe.demo.model.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends CrudRepository<Applicant,Long> {

}
