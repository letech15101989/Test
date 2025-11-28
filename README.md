# Spring Email Service

Simple Spring Boot REST API that sends emails through the configured SMTP server.  
The `from` address is injected from configuration, and the controller accepts the `to`, `subject`, and `message` payload.

## Prerequisites

- Java 17+
- Maven 3.9+
- SMTP credentials (e.g. Mailtrap, Gmail, etc.)

## Configuration

Adjust the properties in `src/main/resources/application.properties`:

```
spring.mail.host=smtp.example.com
spring.mail.port=587
spring.mail.username=your-username
spring.mail.password=your-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

app.mail.from=from@example.com
```

Alternatively, override them via environment variables when running:

```
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.mail.host=smtp.mailtrap.io --spring.mail.username=... --spring.mail.password=... --app.mail.from=no-reply@example.com"
```

## API

`POST /api/email`

Request body:

```
{
  "to": "recipient@example.com",
  "subject": "Optional subject",
  "message": "Body text provided by the visitor",
  "contactName": "Jane Doe",
  "contactEmail": "jane@example.com",
  "contactPhone": "+1 234 567 890",
  "company": "Acme Ltd."
}
```

Returns HTTP `202 Accepted` when the mail dispatch is triggered successfully.

## Running Tests

```
mvn clean test
```

The test suite mocks the `JavaMailSender`, so no SMTP server is required.

