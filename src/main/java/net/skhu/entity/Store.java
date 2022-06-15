package net.skhu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name="store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String locate;
    String time;


    @ManyToOne
    @JoinColumn(name = "locationId")
    Location location;

    @ManyToOne
    @JoinColumn(name = "tagId")
    Tag tag;

    @ManyToOne
    @JoinColumn(name = "moodId")
    Mood mood;

    @ManyToOne
    @JoinColumn(name = "partyId")
    Party party;

}

