package com.letkylehelp.hedberg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kylehebert
 */
@Controller
public class JokeController {
  @RequestMapping("/")
  public String index() {
    return "index";
  }

}
