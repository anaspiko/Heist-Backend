package com.task.heistback.controller;


import com.task.heistback.common.Constants;
import com.task.heistback.model.Skill;
import com.task.heistback.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = Constants.BASE_URL)
@RequestMapping(Constants.URL_EXTENSION + Constants.SKILL)
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    //get all skills
    @GetMapping("/getAllSkills")
    public ResponseEntity<List<Skill>> getAllSkills() {
        return ResponseEntity.ok(skillService.findAll());
    }

    //get skill by id
    @GetMapping("/getSkillById/{skillId}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long skillId) {
        return ResponseEntity.ok(skillService.findById(skillId));
    }

    //create skill
    @PostMapping("/createSkill")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        return ResponseEntity.ok(skillService.createSkill(skill));
    }

}
