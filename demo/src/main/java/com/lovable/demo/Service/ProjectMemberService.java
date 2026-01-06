package com.lovable.demo.Service;

import com.lovable.demo.Dto.Member.InviteMemberRequest;
import com.lovable.demo.Dto.Member.MemberResponse;
import com.lovable.demo.Dto.Member.UpdateMemberRoleRequest;
import com.lovable.demo.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId);

    MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}

