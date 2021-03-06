package com.paw.servertrello.persistance.model;

/**
 * Created by Jakub on 2016-10-23.
 */
public class CardTable {
    private Long id;
    private Long cardListId;
    private String title;
    boolean archived;

    public CardTable(Long id, Long cardListId, String title) {
        this.id = id;
        this.cardListId = cardListId;
        this.title = title;
    }

    public CardTable() {

    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardListId() {
        return cardListId;
    }

    public void setCardListId(Long cardListId) {
        this.cardListId = cardListId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
