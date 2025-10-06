package com.jpquizbot.service;

import com.jpquizbot.model.LeaderboardEntry;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LeaderboardService {
    private final Path storage = Paths.get("data", "leaderboard.json");
    private final ObjectMapper mapper = new ObjectMapper();

    public synchronized List<LeaderboardEntry> loadAll() {
        try {
            if (!Files.exists(storage)) {
                Files.createDirectories(storage.getParent());
                Files.write(storage, "[]".getBytes(), StandardOpenOption.CREATE);
            }
            String json = Files.readString(storage);
            return mapper.readValue(json, new TypeReference<List<LeaderboardEntry>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public synchronized void saveAll(List<LeaderboardEntry> entries) {
        try {
            Files.createDirectories(storage.getParent());
            mapper.writerWithDefaultPrettyPrinter().writeValue(storage.toFile(), entries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void push(LeaderboardEntry entry) {
        List<LeaderboardEntry> list = loadAll();
        list.add(entry);
        saveAll(list);
    }

    public synchronized List<LeaderboardEntry> topForCategory(String cat, int limit) {
        List<LeaderboardEntry> list = loadAll();
        List<LeaderboardEntry> filtered = list.stream()
                .filter(e -> cat == null || cat.isEmpty() || cat.equalsIgnoreCase(e.getCategory()))
                .sorted(Comparator.comparingInt(LeaderboardEntry::getScore).reversed()
                        .thenComparing(e -> e.getTimestamp(), Comparator.reverseOrder()))
                .limit(limit)
                .collect(Collectors.toList());
        return filtered;
    }
}
