package earthquakes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String placeId;
    private String name;
    private double latitude;
    private double longitude;
    private String uid;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlaceId() { return placeId; }
    public void setPlaceId(String PlaceId1) { this.placeId = PlaceId1; }
   
    public String getName() { return name; }
    public void setName (String name1) { this.name = name1; }

    public double getLatitude(){ return latitude;}
    public void setLatitude (double latitude1){ this.latitude = latitude1;}

    public double getLongitude(){ return longitude;}
    public void setLongitude (double longitude1){ this.longitude = longitude1;}

    public String getUid() { return uid;}
    public void setUid (String uid1){ this.uid = uid1;}
}