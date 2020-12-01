package com.ltm.threetree.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tree.round")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRound {
  @Id
  private String id;
}
