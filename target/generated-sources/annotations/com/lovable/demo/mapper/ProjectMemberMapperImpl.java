package com.lovable.demo.mapper;

import com.lovable.demo.Dto.Member.MemberResponse;
import com.lovable.demo.entity.ProjectMember;
import com.lovable.demo.entity.User;
import com.lovable.demo.enums.ProjectRole;
import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-23T14:52:09+0530",
    comments = "version: 1.6.0, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class ProjectMemberMapperImpl implements ProjectMemberMapper {

    @Override
    public MemberResponse toProjectMemberResponseFromOwner(User owner) {
        if ( owner == null ) {
            return null;
        }

        Long userId = null;
        String username = null;
        String name = null;
        String avatarUrl = null;

        userId = owner.getId();
        username = owner.getUsername();
        name = owner.getName();
        avatarUrl = owner.getAvatarUrl();

        ProjectRole role = ProjectRole.OWNER;
        Instant invitedAt = null;

        MemberResponse memberResponse = new MemberResponse( userId, username, name, avatarUrl, role, invitedAt );

        return memberResponse;
    }

    @Override
    public MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember) {
        if ( projectMember == null ) {
            return null;
        }

        Long userId = null;
        String username = null;
        String name = null;
        Instant invitedAt = null;

        userId = projectMemberUserId( projectMember );
        username = projectMemberUserUsername( projectMember );
        name = projectMemberUserName( projectMember );
        invitedAt = projectMember.getInvitedAt();

        String avatarUrl = null;
        ProjectRole role = null;

        MemberResponse memberResponse = new MemberResponse( userId, username, name, avatarUrl, role, invitedAt );

        return memberResponse;
    }

    private Long projectMemberUserId(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    private String projectMemberUserUsername(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getUsername();
    }

    private String projectMemberUserName(ProjectMember projectMember) {
        User user = projectMember.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getName();
    }
}
