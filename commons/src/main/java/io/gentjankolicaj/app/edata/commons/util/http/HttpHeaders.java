package io.gentjankolicaj.app.edata.commons.util.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class HttpHeaders {

    private Map<String, Object> pairs;
}
