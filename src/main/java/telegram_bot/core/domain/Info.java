package telegram_bot.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "INFO")
public class Info implements Serializable {

    @Id
    @Column(name = "info_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long info_id;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "city_info", nullable = false)
    private String city_info;

    public Info() {
    }

    public Long getInfo_id() {
        return info_id;
    }

    public void setInfo_id(Long info_id) {
        this.info_id = info_id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCity_info() {
        return city_info;
    }

    public void setCity_info(String city_info) {
        this.city_info = city_info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(info_id, info.info_id) && Objects.equals(city, info.city)
                && Objects.equals(city_info, info.city_info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info_id, city, city_info);
    }

    @Override
    public String toString() {
        return "Info{" +
                "info_id=" + info_id +
                ", city=" + city +
                ", city_info='" + city_info + '\'' +
                '}';
    }
}