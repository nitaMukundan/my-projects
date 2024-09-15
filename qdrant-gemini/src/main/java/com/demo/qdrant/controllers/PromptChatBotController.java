package com.demo.qdrant.controllers;

import com.demo.qdrant.models.QueryRequest;
import com.demo.qdrant.services.PromptQueryService;
import com.demo.qdrant.services.VectorDataLoaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/1.0.0")
public class PromptChatBotController {

    private final PromptQueryService queryService;

    @PostMapping("/send-query")
    public String sendQuery(@RequestBody QueryRequest query) {
        return queryService.chat(query);
    }
}
