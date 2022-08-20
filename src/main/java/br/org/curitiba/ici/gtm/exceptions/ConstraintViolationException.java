package br.org.curitiba.ici.gtm.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ConstraintViolationException extends RuntimeException {
	private static final long serialVersionUID = -803123796214326575L;
	private final String field;
	private final String message;
}
