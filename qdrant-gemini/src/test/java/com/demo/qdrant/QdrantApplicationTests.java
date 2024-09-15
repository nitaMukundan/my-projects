package com.demo.qdrant;

import com.demo.qdrant.models.QueryRequest;
import com.demo.qdrant.services.PromptQueryService;
import com.demo.qdrant.services.VectorDataLoaderService;
import com.demo.qdrant.services.VectorDataRetrieveService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = QdrantApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QdrantApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(QdrantApplication.class);
	@Autowired
	private VectorDataLoaderService vectorDataLoaderService;

	@Autowired
	private VectorDataRetrieveService vectorDataRetrieveService;

	@Autowired
	private PromptQueryService chat;

	@Test
	void contextLoads() {
		vectorDataLoaderService.load();
		logger.info("loaded!!");
	}

	@Test
	void whenQuery_thenRetrieveSimilarDataFromQdrantVectorDB() {
		String query = "Who provided service";
		List<Document> documents = vectorDataRetrieveService.searchData(query);
		logger.info("The number of documents fetched: {}", documents.size());
		logger.info("Search data: ");
		documents.forEach(e -> logger.info(e.getContent()));
		assertTrue(documents.size() > 1);
	}

	@Test
	void whenQueryAskedWithinContext_thenAnswerFromTheContext() {
		String response = chat.chat(new QueryRequest("Who provided service?"));
		assertNotNull(response);
		logger.info("Response from LLM: {}", response);
	}

	@Test
	void whenQueryAskedWithinContext_thenAnswerFromTheContext1() {
		String response = chat.chat(new QueryRequest("When was the surgery?"));
		assertNotNull(response);
		logger.info("Response from LLM: {}", response);
	}

	@Test
	void whenQueryAskedWithinContext_thenAnswerFromTheContext3() {
		String response = chat.chat(new QueryRequest("What is patients postal address?"));
		assertNotNull(response);
		logger.info("Response from LLM: {}", response);
	}

	@Test
	void whenQueryAskedWithinContext_thenAnswerFromTheContext4() {
		String response = chat.chat(new QueryRequest("How is weather in paris?"));
		assertNotNull(response);
		logger.info("Response from LLM: {}", response);
	}

}
