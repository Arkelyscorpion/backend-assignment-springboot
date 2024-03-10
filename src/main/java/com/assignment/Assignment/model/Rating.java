package com.assignment.Assignment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@IdClass(CompositeKey.class)
@Table(name="Ratings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rating {
    @Id
    @ManyToOne
    private User user;
    @Id
    @ManyToOne
    private Mentor mentor;
    private int rating;
}
