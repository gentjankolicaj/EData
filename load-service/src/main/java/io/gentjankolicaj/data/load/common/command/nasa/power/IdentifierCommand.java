package io.gentjankolicaj.data.load.common.command.nasa.power;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdentifierCommand {

    @NotNull
    private String identifier;

}
