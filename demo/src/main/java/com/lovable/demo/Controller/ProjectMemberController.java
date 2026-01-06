package com.lovable.demo.Controller;

import com.lovable.demo.Dto.Member.InviteMemberRequest;
import com.lovable.demo.Dto.Member.MemberResponse;
import com.lovable.demo.Dto.Member.UpdateMemberRoleRequest;
import com.lovable.demo.Dto.Project.ProjectRequest;
import com.lovable.demo.Dto.Project.ProjectResponse;
import com.lovable.demo.Dto.Project.ProjectSummaryResponse;
import com.lovable.demo.Service.ProjectService;
import com.lovable.demo.entity.ProjectMember;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lovable.demo.Service.ProjectMemberService;
import java.util.List;

@RestController

@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId) {
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId, userId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(
            @PathVariable Long projectId,
            @RequestBody InviteMemberRequest request
    ) {
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(
                projectMemberService.inviteMember(projectId, request, userId)
        );
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(
            @PathVariable Long projectId,
            @PathVariable Long memberId,
            @RequestBody UpdateMemberRoleRequest request
    ) {
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId, memberId, request, userId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<MemberResponse> deleteMember(
            @PathVariable Long projectId,
            @PathVariable Long memberId
    ) {
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.deleteProjectMember(projectId, memberId, userId));
    }










}
