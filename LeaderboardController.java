package com.jpquizbot.controller;

import com.jpquizbot.model.LeaderboardEntry;
import com.jpquizbot.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
@CrossOrigin(origins = "*")
public class LeaderboardController {
    @Autowired
    private LeaderboardService service;

    @GetMapping
    public List<LeaderboardEntry> list(@RequestParam(required=false) String cat,
                                       @RequestParam(required=false, defaultValue="10") int limit) {
        if (cat == null || cat.isEmpty()) {
            return service.loadAll();
        }
        return service.topForCategory(cat, limit);
    }

    @PostMapping
    public ResponseEntity<String> push(@RequestBody LeaderboardEntry entry) {
        if (entry.getTimestamp() == null || entry.getTimestamp().isEmpty()) {
            entry.setTimestamp(java.time.Instant.now().toString());
        }
        service.push(entry);
        return ResponseEntity.ok("saved");
    }

    @GetMapping("/export")
    public ResponseEntity<ByteArrayResource> exportCsv() {
        List<LeaderboardEntry> list = service.loadAll();
        StringBuilder sb = new StringBuilder();
        sb.append("user,displayName,category,score,total,timestamp\n");
        for (LeaderboardEntry e : list) {
            sb.append(escapeCsv(e.getUser())).append(',')
              .append(escapeCsv(e.getDisplayName())).append(',')
              .append(escapeCsv(e.getCategory())).append(',')
              .append(e.getScore()).append(',')
              .append(e.getTotal()).append(',')
              .append(escapeCsv(e.getTimestamp())).append('\n');
        }
        byte[] data = sb.toString().getBytes(StandardCharsets.UTF_8);
        ByteArrayResource resource = new ByteArrayResource(data);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDisposition(ContentDisposition.attachment().filename("quiz_leaderboard.csv").build());
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    private String escapeCsv(String s) {
        if (s == null) return "";
        return s.replace("\"", "\"\"");
    }
}
