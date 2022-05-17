package net.skhu.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name="travels")
public class Travels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int no;
    Date travels_regdate;
    String title;
    int boardId;

    @Basic(fetch = FetchType.LAZY)
    String travels_content;

    @ManyToOne
    @JoinColumn(name = "userId")
    User user;


































}
