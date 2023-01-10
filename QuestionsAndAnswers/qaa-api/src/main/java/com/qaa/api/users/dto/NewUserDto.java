package com.qaa.api.users.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserDto {

  private Long id;

  @NotNull
  @NotEmpty
  private String userName;

  @NotNull
  @NotEmpty
  private String pwd;
}
