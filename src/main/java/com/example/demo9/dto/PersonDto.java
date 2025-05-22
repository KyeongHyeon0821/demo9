package com.example.demo9.dto;

import com.example.demo9.constant.Role;
import com.example.demo9.entity.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class PersonDto {

  private Long id;

  @NotBlank(message = "이름은 필수 입력입니다.")
  private String name;

  @NotEmpty(message = "이메일은 필수 입력입니다.")
  @Email(message = "이메일 형식이 아닙니다.")
  private String email;

  @NotEmpty(message = "비밀번호는 필수 입력입니다.")
  @Length(min = 4, max = 20, message = "비밀번호는 4자 이상 20자 이하로 입력해주세요.")
  private String password;

  @Column(length = 20)
  private String address;

  @Enumerated(EnumType.STRING)
  private Role role;

  // Entity to Dto
  public static PersonDto createPersonDto(Optional<Person> optionalPerson) {
    return PersonDto.builder()
            .id(optionalPerson.get().getId())
            .name(optionalPerson.get().getName())
            .email(optionalPerson.get().getEmail())
            .password(optionalPerson.get().getPassword())
            .address(optionalPerson.get().getAddress())
            .role(optionalPerson.get().getRole())
            .build();
  }
}
