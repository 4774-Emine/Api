package pojoDatas;

public class ZippoPotamPlaces {//Bu classın içinde sadece places in içerisindeki verileri depolayacağız
    /*
    POJO CLASS-->Plain Old Java Object
    Neden kullanıyoruz? Expected yada Actual Dataları depolamak için kullanıyoruz.
    Pojo oluşturabilmek için :
    1)Fieldlar---> var. PRIVATE---> Her bir json için
    2)Parametresiz Constroctur
    3)Parametrelii Const.
    4)Getter and Setter
    5)toString()
    */

   /*
            "places": [
        {
            "place name":"Maltepe Mah.",
                "longitude":"32.3609",
                "state":"İstanbul",
                "state abbreviation":"34",
                "latitude":"40.1589"
        }
  ]*/

    private String placeName;
    private String longitude;
    private String state;
    private String stateAbbreviation;
    private String latitude;

    public ZippoPotamPlaces() {
    }

    public ZippoPotamPlaces(String placeName, String longitude, String state, String stateAbbreviation, String latitude) {
        this.placeName = placeName;
        this.longitude = longitude;
        this.state = state;
        this.stateAbbreviation = stateAbbreviation;
        this.latitude = latitude;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }


    @Override
    public String toString() {
        return "{" +
                "placeName='" + placeName + '\'' +
                ", longitude='" + longitude + '\'' +
                ", state='" + state + '\'' +
                ", stateAbbreviation='" + stateAbbreviation + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
