package com.e17cn2.threetree.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerRound implements Serializable {
    @Id
    private String id;
    private Player player;
    private Card card1;
    private Card card2;
    private Card card3;
}