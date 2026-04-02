package com.taskflow.service.impl;

import com.taskflow.domain.Member;
import com.taskflow.repository.MemberRepository;
import com.taskflow.service.MemberService;
import com.taskflow.service.dto.MemberDTO;
import com.taskflow.service.mapper.MemberMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.taskflow.domain.Member}.
 */
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private static final Logger LOG = LoggerFactory.getLogger(MemberServiceImpl.class);

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    @Override
    public MemberDTO save(MemberDTO memberDTO) {
        LOG.debug("Request to save Member : {}", memberDTO);
        Member member = memberMapper.toEntity(memberDTO);
        member = memberRepository.save(member);
        return memberMapper.toDto(member);
    }

    @Override
    public MemberDTO update(MemberDTO memberDTO) {
        LOG.debug("Request to update Member : {}", memberDTO);
        Member member = memberMapper.toEntity(memberDTO);
        member = memberRepository.save(member);
        return memberMapper.toDto(member);
    }

    @Override
    public Optional<MemberDTO> partialUpdate(MemberDTO memberDTO) {
        LOG.debug("Request to partially update Member : {}", memberDTO);

        return memberRepository
            .findById(memberDTO.getId())
            .map(existingMember -> {
                memberMapper.partialUpdate(existingMember, memberDTO);

                return existingMember;
            })
            .map(memberRepository::save)
            .map(memberMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MemberDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all Members");
        return memberRepository.findAll(pageable).map(memberMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MemberDTO> findOne(Long id) {
        LOG.debug("Request to get Member : {}", id);
        return memberRepository.findById(id).map(memberMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Member : {}", id);
        memberRepository.deleteById(id);
    }
}
