package com.qaa.api.users.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogDto {

  private Long id;

  @NotNull
  @NotEmpty
  private String username;

  @NotNull
  @NotEmpty
  private String pwd;

  @NotNull
  @NotEmpty
  private String email;
}
