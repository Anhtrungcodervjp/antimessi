# ==== Stage 1: Build project bang Maven ====
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml truoc de tan dung cache layer khi dependency khong doi
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy toan bo source code va build ra file .war
COPY src ./src
RUN mvn clean package -DskipTests

# ==== Stage 2: Chay bang Tomcat ====
FROM tomcat:10.1-jdk17-temurin

# Xoa cac app mac dinh cua Tomcat (khong can thiet cho production)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy file .war da build tu stage 1 vao Tomcat, doi ten thanh ROOT.war
# de app chay o duong dan goc "/" thay vi "/ten-project"
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]