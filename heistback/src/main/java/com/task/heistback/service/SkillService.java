package com.task.heistback.service;

import com.task.heistback.model.Skill;
import com.task.heistback.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public Skill findById(Long skillId) {
        return skillRepository.findById(skillId).orElse(null);
    }

    public Skill createSkill(Skill skill) { return skillRepository.save(skill); }

}
