package br.com.all.zip.domain.AddressPoint;

import java.util.Date;

public class AddressPoint {
    private final Integer id;
    private final Integer addressId;
    private final String number;
    private final String complement;
    private final String referenceNote;
    private final String postalCode;
    private final String latitude;
    private final String longitude;
    private final Date createdAt;
    private final Date updatedAt;

    public AddressPoint(Integer id, Integer addressId, String number, String complement, String referenceNote, String postalCode, String latitude, String longitude, Date createdAt, Date updatedAt) {
        this.id = id;
        this.addressId = addressId;
        this.number = number;
        this.complement = complement;
        this.referenceNote = referenceNote;
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public static AddressPoint newAddressPoint(Integer id, Integer addressId, String number, String complement, String referenceNote, String postalCode, String latitude, String longitude, Date createdAt, Date updatedAt) {
        return new AddressPoint(id, addressId, number, complement, referenceNote, postalCode, latitude, longitude, createdAt, updatedAt);
    }
    public static AddressPoint with(
            Integer id,
            Integer addressId,
            String number,
            String complement,
            String referenceNote,
            String postalCode,
            String latitude,
            String longitude,
            Date createdAt,
            Date updatedAt
    ){
        return new AddressPoint(id, addressId, number, complement, referenceNote, postalCode, latitude, longitude, createdAt, updatedAt);
    }


    public Integer getId() {
        return id;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getReferenceNote() {
        return referenceNote;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
