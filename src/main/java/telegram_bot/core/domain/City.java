package telegram_bot.core.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name = "CITIES")
public class City implements Serializable {

    @Id
    @Column(name = "city_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @JoinTable(
            name = "CITIES_INFOS",
            joinColumns = @JoinColumn(
                    name = "city_id",
                    referencedColumnName = "city_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "info_id",
                    referencedColumnName = "info_id"
            )
    )
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Info> cityInfo;

    public City() {
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<Info> getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(Set<Info> cityInfo) {
        this.cityInfo = cityInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityId, city.cityId) && Objects.equals(cityName, city.cityName) && Objects.equals(cityInfo, city.cityInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName, cityInfo);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", cityInfo=" + cityInfo +
                '}';
    }
}