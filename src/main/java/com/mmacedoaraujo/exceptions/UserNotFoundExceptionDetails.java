package com.mmacedoaraujo.exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class UserNotFoundExceptionDetails extends ExceptionDetails {

    private static final long serialVersionUID = 6269339214907188879L;
}
