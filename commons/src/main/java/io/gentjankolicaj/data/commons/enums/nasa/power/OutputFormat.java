package io.gentjankolicaj.data.commons.enums.nasa.power;

public enum OutputFormat {
    JSON("JSON"), ASCII("CSV"), CSV("CSV"), ICASA("ICASA"), NETCDF("NETCDF"), GEOTIFF("GEOTIFF");

    private String value;

    private OutputFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
