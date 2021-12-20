package com.task.heistback.service;

import com.task.heistback.model.Heist;
import com.task.heistback.model.HeistTypeEnum;
import com.task.heistback.model.Member;
import com.task.heistback.model.Skill;
import com.task.heistback.repository.HeistRepository;
import com.task.heistback.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class HeistService {

    private HeistRepository heistRepository;

    private MemberRepository memberRepository;

    public HeistService(
            HeistRepository heistRepository,
            MemberRepository memberRepository
    ) {
        this.heistRepository = heistRepository;
        this.memberRepository = memberRepository;
    }

    public List<Heist> findAll() {
        return heistRepository.findAll();
    }

    public Heist findHeistById(Long heistId) {
        return heistRepository.findById(heistId).orElse(null);
    }

    public Set<Member> findAllMembersByHeistId(int heistId) {
        return heistRepository.findById(heistId + 0L).orElse(null).getMembers();
    }

    public Heist addMemberToHeist(Long heistId, Member member) {
        Set<Member> members = new java.util.HashSet<>(Collections.emptySet());
        if (member.equals(null) || member.getId() == 0) {
            return null;
        }
        members.add(memberRepository.findById(member.getId()).orElse(null));
        Heist savedHeist;
        if (heistId == 0) {
            Heist newHeist = new Heist(1L, "", "", "", Collections.emptySet());
            newHeist.setMembers(members);
            return(heistRepository.save(newHeist));
        }
        savedHeist = heistRepository.findById(heistId).orElse(null);
        members.addAll(savedHeist.getMembers());
        savedHeist.setMembers(members);
        return heistRepository.save(savedHeist);
    }

    public Heist removeMemberFromHeist(Long heistId, Member member) {
        Set<Member> members = new java.util.HashSet<>(Collections.emptySet());
        if (member.equals(null) || member.getId() == 0L) {
            return null;
        }
        if (heistId == 0) {
            Heist newHeist = new Heist(1L, "", "", "", Collections.emptySet());
            newHeist.setMembers(members);
            return(heistRepository.save(newHeist));
        }
        Heist savedHeist;
        savedHeist = heistRepository.findById(heistId).orElse(null);
        members.addAll(savedHeist.getMembers());
        members.remove(memberRepository.findById(member.getId()).orElse(null));
        savedHeist.setMembers(members);
        return heistRepository.save(savedHeist);
    }

    public Heist createHeist(Heist heist) {
        return heistRepository.save(heist);
    }

    public Heist toggleState(Long heistId) {
        Heist heist = heistRepository.findById(heistId).orElse(null);
        if (heist.getStatus().equals(HeistTypeEnum.STARTED.name())) {
            heist.setStatus(HeistTypeEnum.STOPPED.name());
        } else {
            heist.setStatus(HeistTypeEnum.STARTED.name());
        }
        return heistRepository.save(heist);
    }

}
