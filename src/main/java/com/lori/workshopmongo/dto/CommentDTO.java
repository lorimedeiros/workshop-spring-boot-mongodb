package com.lori.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
    //foi optado por não fazer um domain Comment pois (nessa ideia de negócio) comentários são simples e integrados ao post

    private static final long serialVersionUID = 1L;

    private String texto;
    private Date date;
    private AuthorDTO author; //pois é a versão mais simples do user

    public CommentDTO(){}

    public CommentDTO(String texto, Date date, AuthorDTO author) {
        this.texto = texto;
        this.date = date;
        this.author = author;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}