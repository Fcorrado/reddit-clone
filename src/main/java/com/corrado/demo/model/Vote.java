package com.corrado.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor //constructor con todos los argumentos
@NoArgsConstructor //constructor sin argumentos
@Entity //representa una tabla, cada instancia de este objeto representa una linea
@Builder //para patron builder
    public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;
    private VoteType voteType;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY) //fetch lazy significa traer el post cuando se lo pida con getPost()
    //al contrario de "eagerly" que traeria todos juntos
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId") //hace referencia a la columna de la tabla que
    // se encarga de definir la relacion
    private User user;
    }
