# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.3/maven-plugin)
* [Qdrant Cloud Console](https://cloud.qdrant.io/)
* [Spring AI -Qdrant](https://docs.spring.io/spring-ai/reference/api/vectordbs/qdrant.html)
* [Spring AI - Embedding Model API](https://docs.spring.io/spring-ai/reference/api/embeddings/onnx.html)
* [pring AI- Chat Model API](https://docs.spring.io/spring-ai/reference/api/chat/vertexai-gemini-chat.html)
* [GCP ADC Configuration](https://cloud.google.com/docs/authentication/application-default-credentials#personal)
### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

### Before Running the tests
add document/s in resources :: classpath:/test_document.pdf