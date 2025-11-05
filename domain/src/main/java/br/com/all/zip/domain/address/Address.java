package br.com.all.zip.domain.address;

public class Address {
    private final Integer id;
    private final Integer cityId;
    private final Integer stateId;
    private final String address;
    private final String postalCode;
    private final String latitude;
    private final String longitude;
    private final String ddd;

    public Address(Integer id, Integer cityId, Integer stateId, String address, String postalCode, String latitude, String longitude, String ddd) {
        this.id = id;
        this.cityId = cityId;
        this.stateId = stateId;
        this.address = address;
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ddd = ddd;
    }

    public static Address newAddress(Integer id, Integer cityId, Integer stateId, String address, String postalCode, String latitude, String longitude, String ddd) {
        return new Address(null, cityId, stateId, address, postalCode, latitude, longitude, ddd);
    }

    public static Address with(
            Integer id,
            Integer cityId,
            Integer stateId,
            String address,
            String postalCode,
            String latitude,
            String longitude,
            String ddd
    ){
        return new Address(id, cityId, stateId, address, postalCode, latitude, longitude, ddd);
    }

    public Integer getId() {
        return id;
    }
    public Integer getCityId() {
        return cityId;
    }
    public Integer getStateId() {
        return stateId;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }
    public String getLatitude() {
        return latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public String getDdd() {
        return ddd;
    }

}
