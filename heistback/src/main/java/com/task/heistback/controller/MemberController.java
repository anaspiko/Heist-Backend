package com.task.heistback.controller;

import com.task.heistback.common.Constants;
import com.task.heistback.model.Member;
import com.task.heistback.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = Constants.BASE_URL)
@RequestMapping(Constants.URL_EXTENSION + Constants.MEMBER)
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    //get all members
    @GetMapping("/getAllMembers")
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.findAll());
    }

    //get member by id
    @GetMapping("/getMemberById/{memberId}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    //create member
    @PostMapping("/createMember")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.createMember(member));
    }

    //get members by skill id
    @GetMapping("/getMembersBySkillId/{skillId}")
    public ResponseEntity<List<Member>> getMembersBySkillId(@PathVariable int skillId) {
        return ResponseEntity.ok(memberService.findAllMembersBySkillId(skillId));
    }

    //update member
    @PutMapping("/updateMember/{memberId}")
    public ResponseEntity<Member> updateMember(@PathVariable Long memberId, @RequestBody Member member) {
        return ResponseEntity.ok(memberService.updateMember(memberId, member));
    }

    //update member skill
    @PutMapping("/updateMemberSkill/{memberId}")
    public ResponseEntity<Member> updateMemberSkills(@PathVariable Long memberId, @RequestBody Member member) {
        return ResponseEntity.ok(memberService.updateMemberSkill(memberId, member));
    }

}
