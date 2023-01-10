package io.gentjankolicaj.app.edata.commons.domain;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("country")
public class Country implements Serializable {

 @Id
 @Column(name = "countryName")
 private String countryName;

 @Column(name = "phonePrefix")
 private String phonePrefix;

 @Column(name = "isoCodes")
 private String isoCodes;

}
