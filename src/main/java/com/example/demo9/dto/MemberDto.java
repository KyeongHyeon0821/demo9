package com.example.demo9.dto;

import com.example.demo9.constant.Role;
import com.example.demo9.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Optional;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

  private Long id;

  @NotEmpty(message = "이름은 필수 입력입니다.")
  private String name;

  @NotEmpty(message = "이메일은 필수 입력입니다.")
  @Email(message = "이메일 형식이 아닙니다.")
  private String email;

  @NotEmpty(message = "비밀번호는 필수 입력입니다.")
  @Length(min = 4, max = 20, message = "비밀번호는 4자 이상 20자 이하로 입력해주세요.")
  private String password;

  private String address;
  private Role role;

  // Entity to Dto
  public static MemberDto createMemberDto(Optional<Member> opMmember) {
    return MemberDto.builder()
            .id(opMmember.get().getId())
            .name(opMmember.get().getName())
            .email(opMmember.get().getEmail())
            .password(opMmember.get().getPassword())
            .address(opMmember.get().getAddress())
            .role(opMmember.get().getRole())
            .build();
  }



}
