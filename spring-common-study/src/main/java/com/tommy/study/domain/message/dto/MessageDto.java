package com.tommy.study.domain.message.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String message;
  private String sender;
  private String messageUniqueId;
}
