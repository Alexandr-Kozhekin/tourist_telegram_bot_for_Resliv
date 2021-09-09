package telegram_bot.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CITY")
public class City implements Serializable {

    @Id
    @Column(name = "city_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long city_id;

    @Column(name = "city_name", nullable = false)
    private String city_name;

    public City() {
    }

    public City(String name) {
        this.city_name = name;
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(city_id, city.city_id) && Objects.equals(city_name, city.city_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city_id, city_name);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + city_id +
                ", name='" + city_name + '\'' +
                '}';
    }
}