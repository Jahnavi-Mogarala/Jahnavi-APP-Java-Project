# JP QuizBot - Java + Static Frontend

How to run:
1. Java 17, Maven
2. `mvn spring-boot:run`
3. open http://localhost:8080

Static frontend is in `src/main/resources/static` unchanged from original.
APIs:
- GET /api/questions?cat=java&num=15
- GET /api/leaderboard
- POST /api/leaderboard
- GET /api/leaderboard/export
