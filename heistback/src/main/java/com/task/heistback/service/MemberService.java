package com.task.heistback.service;

import com.task.heistback.common.Constants;
import com.task.heistback.model.Member;
import com.task.heistback.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

    public List<Member> findAllMembersBySkillId(int skillId) {
//        return memberRepository.FindAllWithDescriptionQuery(skillId);
        return null;
    }

    public Member createMember(Member member) {
        member.setImage(Constants.IMAGE_URL);
        return memberRepository.save(member);
    }

    public Member updateMemberSkill(Long memberId, Member updatedMember) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return null;
        }
        member.setSkill(updatedMember.getSkill());
        return memberRepository.save(member);
    }

    public Member updateMember(Long memberId, Member updatedMember) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return null;
        }
        member = updatedMember;
        return memberRepository.save(member);
    }

    public Boolean deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        memberRepository.delete(member);
        return true;
    }
}
