package io.gentjankolicaj.data.load.client.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestClientDetails {

    private String provider;
    private String baseUrl;
    private String apiKey;
    private String user;

}
