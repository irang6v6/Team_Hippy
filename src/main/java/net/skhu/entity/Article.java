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
@Entity(name="article")
public class Article {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int no;
    int view;
    Date modifiedTime;
    String title;
    int boardId;

    @Basic(fetch = FetchType.LAZY)
    String body;
    
    @ManyToOne
    @JoinColumn(name = "locationId")
    Location location;
    
    public void increaseView() {
    	this.view++;
    }
}