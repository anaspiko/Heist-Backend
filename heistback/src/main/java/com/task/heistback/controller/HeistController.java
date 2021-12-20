package com.task.heistback.controller;

import com.task.heistback.common.Constants;
import com.task.heistback.model.Heist;
import com.task.heistback.model.Member;
import com.task.heistback.service.HeistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = Constants.BASE_URL)
@RequestMapping(Constants.URL_EXTENSION + Constants.HEIST)
public class HeistController {

    private final HeistService heistService;

    public HeistController(HeistService heistService) {
        this.heistService = heistService;
    }

    //get all heists
    @GetMapping("/getAllHeists")
    public ResponseEntity<List<Heist>> getAllHeists() {
        return ResponseEntity.ok(heistService.findAll());
    }

    //get heist by id
    @GetMapping("/{heistId}")
    public ResponseEntity<Heist> getHeistById(@PathVariable Long heistId) {
        return ResponseEntity.ok(heistService.findHeistById(heistId));
    }

    //create heist
    @PostMapping("/createHeist")
    public ResponseEntity<Heist> createHeist(@RequestBody Heist heist) {
        return ResponseEntity.ok(heistService.createHeist(heist));
    }

    //get Heist Members
    @GetMapping("/getMembersForHeist/{heistId}")
    public ResponseEntity<Set<Member>> getMembersForHeist(@PathVariable Integer heistId) {
        return ResponseEntity.ok(heistService.findAllMembersByHeistId(heistId));
    }

    //toggle Heist state
    @GetMapping("/toggleState/{heistId}")
    public ResponseEntity<Heist> toggleState(@PathVariable Long heistId) {
        return ResponseEntity.ok(heistService.toggleState(heistId));
    }

    //insert Member To Heist
    @PutMapping("/addMemberToHeist/{heistId}")
    public ResponseEntity<Heist> addMemberToHeist(@PathVariable Long heistId, @RequestBody  Member member) {
        return ResponseEntity.ok(heistService.addMemberToHeist(heistId, member));
    }

    //remove Member From Heist
    @PutMapping("/removeMemberFromHeist/{heistId}")
    public ResponseEntity<Heist> removeMemberFromHeist(@PathVariable Long heistId, @RequestBody Member member) {
        return ResponseEntity.ok(heistService.removeMemberFromHeist(heistId, member));
    }

}
