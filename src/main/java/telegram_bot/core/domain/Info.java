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
    private Long infoId;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "city_info", nullable = false)
    private String cityInfo;

    public Info() {
    }

    public Info(City city, String cityInfo) {
        this.city = city;
        this.cityInfo = cityInfo;
    }

    public Info(String cityInfo) {
        this.cityInfo = cityInfo;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(String cityInfo) {
        this.cityInfo = cityInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(infoId, info.infoId) && Objects.equals(city, info.city) && Objects.equals(cityInfo, info.cityInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(infoId, city, cityInfo);
    }

    @Override
    public String toString() {
        return "Info{" +
                "infoId=" + infoId +
                ", city=" + city +
                ", cityInfo='" + cityInfo + '\'' +
                '}';
    }
}