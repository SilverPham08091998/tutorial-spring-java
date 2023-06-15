package com.example.springjava.payload.request;

import com.example.springjava.model.AuthenciationDTO;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpPayload extends AuthenciationDTO {

}
