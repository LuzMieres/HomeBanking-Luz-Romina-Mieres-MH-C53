package com.mindhub.HomeBanking.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mindhub.HomeBanking.models.CardColor;
import com.mindhub.HomeBanking.models.CardEntity;
import com.mindhub.HomeBanking.models.CardType;
import com.mindhub.HomeBanking.models.ClientEntity;

import java.time.LocalDate;

public class CardDTO {
    private Long id;

    private ClientEntity client;
    private String cardHolder, number, cvv;
    @JsonProperty("start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    @JsonProperty("end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate thruDate;

    private CardType type;

    private CardColor color;

    public CardDTO() {
    }

    public CardDTO(CardEntity card) {
        this.id = card.getId();
        this.client = card.getClient();
        this.cardHolder = card.getCardHolder();
        this.number = card.getNumber();
        this.cvv = card.getCvv();
        this.fromDate = card.getFromDate();
        this.thruDate = card.getThruDate();
        this.type = card.getType();
        this.color = card.getColor();
    }

    @Override
    public String toString() {
        return "CardDTO{" +
                "id=" + id +
                ", client=" + client +
                ", cardHolder='" + cardHolder + '\'' +
                ", number='" + number + '\'' +
                ", cvv='" + cvv + '\'' +
                ", fromDate=" + fromDate +
                ", thruDate=" + thruDate +
                ", type=" + type +
                ", color=" + color +
                '}';
    }
}
