package edata.common.command;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryCommand {

    private String countryName;

    private String phonePrefix;

    private String isoCodes;


}
