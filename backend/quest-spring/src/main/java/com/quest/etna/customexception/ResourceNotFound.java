package com.quest.etna.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "resource doesn't exist")
public class ResourceNotFound extends RuntimeException  {

}
