package hiber.model;

import javax.persistence.*;

@Table(name = "car")
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String model;
    private String series;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series='" + series + '\'' +
                '}';
    }

    @OneToOne(mappedBy = "car")
    private User user;

    public Car(String model, String series) {
        this.id = id;
        this.model = model;
        this.series = series;
    }

    public Car() {

    }
}
