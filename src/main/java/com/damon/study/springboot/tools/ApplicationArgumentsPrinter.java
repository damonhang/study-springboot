package com.damon.study.springboot.tools;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ApplicationArgumentsPrinter {
  @Autowired
  public ApplicationArgumentsPrinter(ApplicationArguments args) {
    boolean debug = args.containsOption("debug");
    List<String> files = args.getNonOptionArgs();
    // if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
  }
}
