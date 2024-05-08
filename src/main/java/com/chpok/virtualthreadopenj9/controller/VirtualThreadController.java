package com.chpok.virtualthreadopenj9.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Duration;

@Controller
@Slf4j
public class VirtualThreadController {
    private final static Logger LOGGER = LoggerFactory.getLogger(VirtualThreadController.class);

    @GetMapping(path = "/vt-demo/{seconds}")
    public ResponseEntity<String> demo(@PathVariable int seconds) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(seconds).toMillis());

        final String threadName = Thread.currentThread().getName();

        LOGGER.info(threadName);

        return ResponseEntity.ok(Thread.currentThread().getName());
    }
}
