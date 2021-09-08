package telegram_bot.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CITY_INFO")
public class CityInfo implements Serializable {

    @Id
    @Column(name = "info_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoId;

    @ManyToOne
    @JoinColumn(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "info", nullable = false)
    private String info;

    public CityInfo() {
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityInfo cityInfo = (CityInfo) o;
        return Objects.equals(infoId, cityInfo.infoId) && Objects.equals(cityName, cityInfo.cityName) && Objects.equals(info, cityInfo.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(infoId, cityName, info);
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "infoId=" + infoId +
                ", cityName='" + cityName + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}