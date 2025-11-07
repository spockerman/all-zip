package br.com.all.zip.domain.address;

public class Address {
    private final Integer id;
    private final Integer cityId;
    private final String cityName;
    private final Integer districtId;
    private final String districtName;
    private final String address;
    private final String postalCode;
    private final String latitude;
    private final String longitude;
    private final String ddd;

    public Address(Integer id, Integer cityId, String cityName, Integer districtId, String districtName, String address, String postalCode, String latitude, String longitude, String ddd) {
        this.id = id;
        this.cityId = cityId;
        this.cityName = cityName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.address = address;
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ddd = ddd;
    }

    public static Address newAddress(Integer id, Integer cityId, String cityName, Integer districtId, String districtName, String address, String postalCode, String latitude, String longitude, String ddd) {
        return new Address(null, cityId, cityName,  districtId, districtName, address, postalCode, latitude, longitude, ddd);
    }

    public static Address with(
            Integer id,
            Integer cityId,
            String cityName,
            Integer districtId,
            String districtName,
            String address,
            String postalCode,
            String latitude,
            String longitude,
            String ddd
    ){
        return new Address(id, cityId, cityName, districtId, districtName, address, postalCode, latitude, longitude, ddd);
    }

    public Integer getId() {
        return id;
    }
    public Integer getCityId() {
        return cityId;
    }
    public String getCityName() {
        return cityName;
    }
    public Integer getDistrictId() {
        return districtId;
    }
    public String getDistrictName() {
        return districtName;
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
