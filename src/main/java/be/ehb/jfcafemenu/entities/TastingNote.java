package be.ehb.jfcafemenu.entities;

import jakarta.persistence.*;

@Entity
public class TastingNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private int score;
    @ManyToOne
    //hay muchos sabores posibles para un cafe!!
    @JoinColumn(name= "DrinkID", nullable = false)
    private Drink drink;

    public TastingNote(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
