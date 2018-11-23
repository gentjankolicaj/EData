package edata.config.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyDatabase {

    private String platform;
    private String driverName;
    private String username;
    private String password;
    private String url;
    private String schema;
    private Integer port;
    private Boolean ssl;

}
