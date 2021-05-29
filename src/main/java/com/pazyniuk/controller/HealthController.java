package com.pazyniuk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {
  
  @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
  public ResponseEntity returnHealthCheckResponse() {
      return new ResponseEntity<>("Everything is OK", HttpStatus.OK);
  }
}
