package com.paw.servertrello.persistance.Converters;

import com.paw.servertrello.lib.Card;
import com.paw.servertrello.persistance.model.CardTable;

/**
 * Created by Jakub on 2016-10-23.
 */
public class CardConverter {
    public static Card convertFromEntityToDto(CardTable cardTable){
        Card card = new Card();
        card.setId(cardTable.getId());
        card.setTitle(cardTable.getTitle());
        card.setCardListId(cardTable.getCardListId());
        card.setArchived(cardTable.isArchived());
        return card;
    }

    public static CardTable convertFromDtoToEntity(Card card) {
        CardTable cardTable = new CardTable();
        cardTable.setId(card.getId());
        cardTable.setTitle(card.getTitle());
        cardTable.setCardListId(card.getCardListId());
        cardTable.setArchived(card.isArchived());
        return cardTable;
    }
}
