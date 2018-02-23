package me.abebe.demo.repo;

import me.abebe.demo.model.DesiredSkills;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DesiredSkillsRepository extends CrudRepository<DesiredSkills,Long> {
    public List<DesiredSkills> findSkillsByPersonId(Long personId);

    public List<DesiredSkills> findBySkill(String skill);

    public List<DesiredSkills> findByJob_JobId(Long jobId);
}
