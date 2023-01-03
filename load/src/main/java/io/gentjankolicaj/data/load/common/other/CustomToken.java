package io.gentjankolicaj.data.load.common.other;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomToken {

    private String token;
    private int validity;

}
